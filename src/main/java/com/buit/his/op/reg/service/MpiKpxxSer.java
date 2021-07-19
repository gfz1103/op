package com.buit.his.op.reg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buit.commons.request.*;
import com.buit.commons.response.MpiKpxxPrintFpResp;
import com.buit.commons.response.OpCzFkxxResp;
import com.buit.his.op.reg.enums.OpPjlxEnum;
import com.buit.system.utill.ObjectToTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.MpiCardDao;
import com.buit.commons.dao.MpiKpxxDao;
import com.buit.commons.dao.OpCzFkxxDao;
import com.buit.commons.dao.OpCzTfxxDao;
import com.buit.commons.dao.OpCzjlDao;
import com.buit.commons.dao.OpPosmxDao;
import com.buit.commons.model.OpCzFkxx;
import com.buit.commons.model.OpCzTfxx;
import com.buit.commons.response.OpCzjlResp;
import com.buit.commons.response.QueryMpiCardResp;
import com.buit.constans.TableName;
import com.buit.op.model.MpiKpxx;
import com.buit.op.model.OpCzjl;
import com.buit.op.model.OpPosmx;
import com.buit.utill.MzUtil;
import com.buit.utill.RedisFactory;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;

/**
 * 充值卡管理<br>
 * 
 * @author WY
 */
@Service
public class MpiKpxxSer extends BaseManagerImp<MpiKpxx, Integer> {

	static final Logger logger = LoggerFactory.getLogger(MpiKpxxSer.class);

	@Autowired
	private MpiKpxxDao mpiKpxxDao;

	@Autowired
	private MpiCardDao mpiCardDao;

	@Autowired
	private OpCzjlDao opCzjlDao;

	@Autowired
	private OpCzFkxxDao opCzFkxxDao;

	@Autowired
	private OpPosmxDao opPosmxDao;

	@Autowired
	private OpCzTfxxDao opCzTfxxDao;

	@Autowired
	private RedisFactory redisFactory;

	@Autowired
	private OpGhksSer opGhksSer;

	@Override
	public MpiKpxxDao getEntityMapper() {
		return mpiKpxxDao;
	}

	/**
	 * 充值卡分页查询
	 * 
	 * @param cardno
	 * @return
	 */
	public List<MpiKpxx> doQueryCzkList(String cardno) {
		MpiKpxx mpiKpxx = new MpiKpxx();
		if (!"".equals(cardno) && cardno != null) {
			mpiKpxx.setCardno(cardno);
			mpiKpxx.setBrxm(cardno);
			mpiKpxx.setIdcard(cardno);
		} else {
			mpiKpxx.setCardno(cardno);
		}

		List<MpiKpxx> resultList = mpiKpxxDao.doQueryCzkList(mpiKpxx);
		return resultList;
	}

	/**
	 * 充值卡登记卡号查询
	 * 
	 * @param cardno
	 * @return
	 */
	public QueryMpiCardResp doQueryMpiCard(String cardno) {
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("CARDNO", cardno);
		Map<String, Object> result = mpiCardDao.getMpiCardInfoByCardNo(parameters);
//		result.put("fksj", DateUtil.date().toSqlDate());
		QueryMpiCardResp resp = BeanUtil.fillBeanWithMapIgnoreCase(result, new QueryMpiCardResp(), true);
		return resp;
	}

	/**
	 * 充值卡登记
	 * 
	 * @param req
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveIssuingCards(SaveIssuingCardsReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		// 补全发卡数据
		// 操作工号
		body.put("CZGH", req.getYgdm());
		// 操作IP
		body.put("CZIP", req.getIp());
		// 卡内余额
		body.put("KNYE", 0.00);
		// 当前时间
		body.put("FKSJ", DateUtil.date().toTimestamp());

		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("cardno", body.get("CARDNO"));
		List<Map<String, Object>> list = mpiKpxxDao.getMpiKpxxByCardNo(map);
		if (list.size() > 0) {
			throw BaseException.create("ERROR_REG_0050");
		}
		// 保存充值卡管理数据(写入数据到MPI_KPXX表)
		MpiKpxx mpiKpxx = BeanUtil.fillBeanWithMapIgnoreCase(body, new MpiKpxx(), true);
		mpiKpxx.setCardid(redisFactory.getTableKey(TableName.DB_NAME, TableName.MPI_KPXX));
		mpiKpxxDao.insert(mpiKpxx);
		// 保存充值卡操作记录数据(写入数据到OP_CZJL表)
		Map<String, Object> czjl = new HashMap<String, Object>(16);
		// 卡号
		czjl.put("CARDNO", body.get("CARDNO"));
		// 操作类型 01登记 02充值 03退费 04挂失 05解挂 06注销
		czjl.put("CZTYPE", "01");
		// 金额
		czjl.put("AMOUNT", 0.00);
		// 操作工号
		czjl.put("CZGH", req.getYgdm());
		// 操作IP
		czjl.put("CZIP", req.getIp());
		// 操作时间
		czjl.put("CZSJ", mpiKpxx.getFksj());
		// 病人ID
		czjl.put("BRID", ObjectToTypes.parseLong(body.get("BRID")));
		// 上次余额
		czjl.put("LASTKNYE", 0.00);

		OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(czjl, new OpCzjl(), true);
		opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(opCzjl);
	}

	/**
	 * 卡号查询充值卡信息
	 * 
	 * @param cardno
	 */
	public MpiKpxx doQueryKpxx(String cardno) {
		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("CARDNO", cardno);
		Map<String, Object> result = mpiKpxxDao.getKpxxBycardNo(parameters);
		MpiKpxx mpiKpxx = BeanUtil.fillBeanWithMapIgnoreCase(result, new MpiKpxx(), true);
		return mpiKpxx;
	}

	/**
	 * 充值
	 * 
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public Integer doSaveRecharge(SaveRechargeReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> parameters = new HashMap<String, Object>(16);

		// 充值卡ID
		long cardId = Long.parseLong(body.get("CARDID").toString());
		// 操作工号
		String czgh = String.valueOf(req.getYgdm());
		// 操作IP
		// String ip = ZYYPUtil.getConfig().get("IP").toString();
		String ip = req.getIp();
		// 充值金额
		double czje = Double.parseDouble(body.get("CZJE").toString());
		// 充值后余额
		double czhye = Double.parseDouble(body.get("CZHYE").toString());

//			String upSql = "update MPI_KPXX set CZGH=:CZGH,CZIP=:CZIP,KNYE=:KNYE where CARDID = :CARDID";

		// 保存充值卡操作记录数据(写入数据到OP_CZJL表)
		Map<String, Object> czjl = new HashMap<String, Object>(16);
		// 卡号
		czjl.put("CARDNO", body.get("CARDNO"));
		// 操作类型 01发卡 02充值 03退费 04挂失 05解挂 06注销
		czjl.put("CZTYPE", "02");
		// 操作金额
		czjl.put("AMOUNT", czje);
		// 操作工号
		czjl.put("CZGH", req.getYgdm());
		// 操作IP
		czjl.put("CZIP", ip);
		// 操作时间
		czjl.put("CZSJ", DateUtil.date().toTimestamp());
		// 病人ID
		czjl.put("BRID", ObjectToTypes.parseLong(body.get("BRID")));
		czjl.put("CZFS", Long.parseLong(body.get("CZFS").toString()));
		czjl.put("LASTKNYE", czhye - czje);

		OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(czjl, new OpCzjl(), true);
		opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(opCzjl);

		Map<String, Object> czxhMap = MzUtil.caseInsensitiveMap(opCzjl);
		parameters.put("CARDID", cardId);
//			parameters.put("CZGH", czgh);
//			parameters.put("CZIP", ip);
		parameters.put("KNYE", czje);
		mpiKpxxDao.updateKnyeByCardId(parameters);

		// 保存到付款信息
		Map<String, Object> czfkxx = new HashMap<String, Object>(16);
		czfkxx.put("JGID", req.getJgid());
		czfkxx.put("CARDID", cardId);
		czfkxx.put("CZRQ", DateUtil.date().toTimestamp());
		czfkxx.put("CZFS", Long.parseLong(body.get("CZFS").toString()));
		czfkxx.put("CZJE", czje);
		czfkxx.put("CZGH", req.getYgdm());
		czfkxx.put("MZLB", 1L);
		czfkxx.put("CZPJ", opGhksSer.getNotesNumber(req.getYgdm(), req.getJgid(), OpPjlxEnum.CZHM.getKey()));

		OpCzFkxx opCzFkxx = BeanUtil.fillBeanWithMapIgnoreCase(czfkxx, new OpCzFkxx(), true);
		opCzFkxx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZ_FKXX));
		opCzFkxxDao.insert(opCzFkxx);
		// POS机交易
		// 付费方式
		String fffs = ObjectToTypes.null2Str(body.get("CZFS"));
		Map<String, Object> pos = MzUtil.caseInsensitiveMap(req.getPos());
		// 付费方式：POS机(新添微信支付宝)，写入pos机交易信息
		if (("3".equals(fffs) || "12".equals(fffs) || "18".equals(fffs)) && "1".equals(pos.get("success"))) {
			Map<String, Object> posInfo = new HashMap<String, Object>(16);
			// posInfo.put("ID", id);
			posInfo.put("JYSJ", DateUtil.date());
			posInfo.put("JYLB", pos.get("TransType"));
			posInfo.put("FPHM", czxhMap.get("CZXH"));

			OpPosmx msOpPosmx = BeanUtil.fillBeanWithMapIgnoreCase(posInfo, new OpPosmx(), true);
			msOpPosmx.setId(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_POSMX));
			opPosmxDao.insert(msOpPosmx);
		}
		Integer czxh = czxhMap.get("CZXH") != null ? Integer.valueOf(czxhMap.get("CZXH").toString()) : 0;
		return czxh;
	}

	/**
	 * 余额转出
	 * 
	 * @param req
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveTransfer(SaveTransferReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> parameters = new HashMap<String, Object>(16);

		long cardIdOut = Long.parseLong(body.get("CARDIDOUT").toString());
		long cardIdIn = Long.parseLong(body.get("CARDIDIN").toString());

		double zcje = Double.parseDouble(body.get("KNYEOUT").toString());
		double zrje = Double.parseDouble(body.get("KNYEIN").toString());

		String czgh = String.valueOf(req.getYgdm());
		// 操作IP
		// String ip = ZYYPUtil.getConfig().get("IP").toString();
		String ip = req.getIp();

		Map<String, Object> parametersZcye = new HashMap<String, Object>(16);
		parametersZcye.put("CARDID", cardIdOut);
		List<Map<String, Object>> list = mpiKpxxDao.getknyeByCardId(parametersZcye);
		// 保存充值卡操作记录数据(写入数据到OP_CZJL表)
		Map<String, Object> czjl = new HashMap<String, Object>(16);
		// 卡号
		czjl.put("CARDNO", body.get("CARDNOOUT"));
		// 操作类型 01发卡 02充值 03退费 04挂失 05解挂 06注销
		czjl.put("CZTYPE", "13");
		// 操作金额
		czjl.put("AMOUNT", zcje);
		// 操作工号
		czjl.put("CZGH", czgh);
		// 操作IP
		czjl.put("CZIP", ip);
		// 操作时间
		czjl.put("CZSJ", DateUtil.date().toTimestamp());
		// 病人ID
		czjl.put("BRID", ObjectToTypes.parseLong(body.get("BRIDOUT")));
		czjl.put("LASTKNYE", ObjectToTypes.parseDouble(list.get(0).get("KNYE")));

		OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(czjl, new OpCzjl(), true);
		opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(opCzjl);

		parameters.put("CARDID", cardIdOut);
		parameters.put("KNYE", zcje);
		mpiKpxxDao.updateKnyeSubtr(parameters);

		Map<String, Object> parametersZrye = new HashMap<String, Object>(16);
		parametersZrye.put("CARDID", cardIdIn);
		List<Map<String, Object>> listZrye = mpiKpxxDao.getknyeByCardId(parametersZrye);

		// 保存充值卡操作记录数据(写入数据到OP_CZJL表)
		Map<String, Object> czjlIn = new HashMap<String, Object>(16);
		// 卡号
		czjlIn.put("CARDNO", body.get("CARDNOIN"));
		czjlIn.put("CZTYPE", "14");
		// 操作金额
		czjlIn.put("AMOUNT", zrje);
		// 操作工号
		czjlIn.put("CZGH", czgh);
		// 操作IP
		czjlIn.put("CZIP", ip);
		// 操作时间
		czjlIn.put("CZSJ", DateUtil.date().toTimestamp());
		// 病人ID
		czjlIn.put("BRID", ObjectToTypes.parseLong(body.get("BRIDIN")));
		czjlIn.put("LASTKNYE", ObjectToTypes.parseDouble(listZrye.get(0).get("KNYE")));

		OpCzjl cj = BeanUtil.fillBeanWithMapIgnoreCase(czjlIn, new OpCzjl(), true);
		cj.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(cj);

		parameters.put("CARDID", cardIdIn);
		parameters.put("KNYE", zrje);
		mpiKpxxDao.updateKnyeByCardId(parameters);
	}

	/**
	 * 、 退费
	 * 
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveRefund(SaveRefundReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> parameters = new HashMap<String, Object>(16);

		// 充值卡ID
		long cardId = Long.parseLong(body.get("CARDID").toString());
		// 操作工号
		String czgh = String.valueOf(req.getYgdm());
		// 操作IP
		// String ip = ZYYPUtil.getConfig().get("IP").toString();
		String ip = req.getIp();
		// 退费金额
		double tfje = Double.parseDouble(body.get("TFJE").toString());
		// 退费后余额
		double tfhye = Double.parseDouble(body.get("TFHYE").toString());

		// 保存充值卡操作记录数据(写入数据到OP_CZJL表)
		Map<String, Object> czjl = new HashMap<String, Object>(16);
		// 卡号
		czjl.put("CARDNO", body.get("CARDNO"));
		// 操作类型 01发卡 02充值 03退费 04挂失 05解挂 06注销
		czjl.put("CZTYPE", "03");
		// 操作金额
		czjl.put("AMOUNT", tfje);
		// 操作工号
		czjl.put("CZGH", req.getYgdm());
		// 操作IP
		czjl.put("CZIP", ip);
		// 操作时间
		czjl.put("CZSJ", DateUtil.date().toTimestamp());
		// 病人ID
		czjl.put("BRID", ObjectToTypes.parseLong(body.get("BRID")));
		czjl.put("CZFS", Long.parseLong(body.get("TFFS").toString()));
		czjl.put("LASTKNYE", tfhye + tfje);

		OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(czjl, new OpCzjl(), true);
		opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(opCzjl);

		parameters.put("CARDID", cardId);
//			parameters.put("CZGH", czgh);
//			parameters.put("CZIP", ip);
		parameters.put("KNYE", tfje);
		mpiKpxxDao.updateKnyeSubtr(parameters);

		// 保存到退费信息
		Map<String, Object> cztfxx = new HashMap<String, Object>(16);
		cztfxx.put("JGID", req.getJgid());
		cztfxx.put("CARDID", cardId);
		cztfxx.put("TFRQ", DateUtil.date().toTimestamp());
		cztfxx.put("TFFS", Long.parseLong(body.get("TFFS").toString()));
		cztfxx.put("TFJE", tfje);
		cztfxx.put("CZGH", req.getYgdm());
		cztfxx.put("MZLB", 1L);

		OpCzTfxx opCzTfxx = BeanUtil.fillBeanWithMapIgnoreCase(cztfxx, new OpCzTfxx(), true);
		opCzTfxx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZ_TFXX));
		opCzTfxxDao.insert(opCzTfxx);
	}

	/**
	 * 挂失
	 * 
	 * @param cardid
	 * @param cardno
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveRegloss(SaveReglossReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> parameters = new HashMap<String, Object>(16);

		// 操作工号
		String czgh = String.valueOf(req.getYgdm());
		// 操作IP
		// String ip = ZYYPUtil.getConfig().get("IP").toString();
		String ip = req.getIp();

		parameters.put("CARDID", Long.parseLong(body.get("CARDID").toString()));
		parameters.put("STATUS", "1");
//			parameters.put("CZGH", czgh);
//			parameters.put("CZIP", ip);
		// 更新充值卡状态为挂失状态(设置STATUS=1)
		mpiKpxxDao.updateStatus(parameters);

		// 更改状态不能影响卡片
		// 更新病人档案的卡片信息
//		Map<String, Object> upCard = new HashMap<String, Object>(16);
//		upCard.put("CARDNO", body.get("CARDNO"));

//		MpiCard mpiCard = new MpiCard();
//		mpiCard.setStatus("1");
//		mpiCard.setCardno(body.get("CARDNO") != null ? body.get("CARDNO").toString() : null);
//		mpiCardDao.updateCardStatus(mpiCard);

		Integer cardId = body.get("CARDID") != null ? Integer.valueOf(body.get("CARDID").toString()) : 0;
		MpiKpxx mpiKpxx = mpiKpxxDao.getById(cardId);
		Map<String, Object> kpxx = MzUtil.caseInsensitiveMap(mpiKpxx);

		// 保存充值卡操作记录数据(写入数据到OP_CZJL表)
		Map<String, Object> czjl = new HashMap<String, Object>(16);
		// 卡号
		czjl.put("CARDNO", body.get("CARDNO"));
		// 操作类型 01发卡 02充值 03退费 04挂失 05解挂 06注销
		czjl.put("CZTYPE", "04");
		// 金额
		czjl.put("AMOUNT", 0.00);
		// 操作工号
		czjl.put("CZGH", req.getYgdm());
		// 操作IP
		czjl.put("CZIP", ip);
		// 操作时间
		czjl.put("CZSJ", DateUtil.date().toTimestamp());
		// 病人ID
		czjl.put("BRID", ObjectToTypes.parseLong(kpxx.get("BRID")));
		czjl.put("LASTKNYE", kpxx.get("KNYE"));

		OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(czjl, new OpCzjl(), true);
		opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(opCzjl);
	}

	/**
	 * 解挂
	 * 
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveUnregloss(SaveReglossReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> parameters = new HashMap<String, Object>(16);

		// 操作工号
		String czgh = String.valueOf(req.getYgdm());
		// 操作IP
		// String ip = ZYYPUtil.getConfig().get("IP").toString();
		String ip = req.getIp();
		parameters.put("CARDID", Long.parseLong(body.get("CARDID").toString()));
		parameters.put("STATUS", "0");
//			parameters.put("CZGH", czgh);
//			parameters.put("CZIP", ip);
		// 更新充值卡状态为挂失状态(设置STATUS=0)
		mpiKpxxDao.updateStatus(parameters);

		// 更改状态不能影响卡片
		// 更新病人档案的卡片信息
//		Map<String, Object> upCard = new HashMap<String, Object>(16);
//		upCard.put("CARDNO", body.get("CARDNO"));
//
//		MpiCard mpiCard = new MpiCard();
//		mpiCard.setStatus("0");
//		mpiCard.setCardno(body.get("CARDNO") != null ? body.get("CARDNO").toString() : null);
//		mpiCardDao.updateCardStatus(mpiCard);

		Integer cardId = body.get("CARDID") != null ? Integer.valueOf(body.get("CARDID").toString()) : 0;
		MpiKpxx mpiKpxx = mpiKpxxDao.getById(cardId);
		Map<String, Object> kpxx = MzUtil.caseInsensitiveMap(mpiKpxx);

		// 保存充值卡操作记录数据(写入数据到OP_CZJL表)
		Map<String, Object> czjl = new HashMap<String, Object>(16);
		// 卡号
		czjl.put("CARDNO", body.get("CARDNO"));
		// 操作类型 01发卡 02充值 03退费 04挂失 05解挂 06注销
		czjl.put("CZTYPE", "05");
		// 金额
		czjl.put("AMOUNT", 0.00);
		// 操作工号
		czjl.put("CZGH", req.getYgdm());
		// 操作IP
		czjl.put("CZIP", ip);
		// 操作时间
		czjl.put("CZSJ", DateUtil.date().toTimestamp());
		// 病人ID
		czjl.put("BRID", ObjectToTypes.parseLong(kpxx.get("BRID")));
		czjl.put("LASTKNYE", kpxx.get("KNYE"));
		OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(czjl, new OpCzjl(), true);
		opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(opCzjl);
	}

	/**
	 * 注销
	 * 
	 * @param req
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveLogout(SaveReglossReq req) {
		Map<String, Object> body = MzUtil.caseInsensitiveMap(req);
		Map<String, Object> parameters = new HashMap<String, Object>(16);

		// 操作工号
		String czgh = String.valueOf(req.getYgdm());
		// 操作IP
		// String ip = ZYYPUtil.getConfig().get("IP").toString();
		String ip = req.getIp();

		parameters.put("CARDID", Long.parseLong(body.get("CARDID").toString()));
		parameters.put("CZGH", czgh);
		parameters.put("CZIP", ip);
		parameters.put("STATUS", "2");
		// 更新充值卡状态为挂失状态(设置STATUS=2)
		mpiKpxxDao.updateStatus(parameters);

		// 更改状态不能影响卡片
		// 更新病人档案的卡片信息
//		Map<String, Object> upCard = new HashMap<String, Object>(16);
//		upCard.put("CARDNO", body.get("CARDNO"));
//
//		MpiCard mpiCard = new MpiCard();
//		mpiCard.setStatus("2");
//		mpiCard.setCardno(body.get("CARDNO") != null ? body.get("CARDNO").toString() : null);
//		mpiCardDao.updateCardStatus(mpiCard);

		Integer id = body.get("CARDID") != null ? Integer.valueOf(body.get("CARDID").toString()) : 0;
		MpiKpxx mpiKpxx = mpiKpxxDao.getById(id);
		Map<String, Object> kpxx = MzUtil.caseInsensitiveMap(mpiKpxx);

		// 保存充值卡操作记录数据(写入数据到OP_CZJL表)
		Map<String, Object> czjl = new HashMap<String, Object>(16);
		// 卡号
		czjl.put("CARDNO", body.get("CARDNO"));
		// 操作类型 01发卡 02充值 03退费 04挂失 05解挂 06注销
		czjl.put("CZTYPE", "06");
		// 金额
		czjl.put("AMOUNT", 0.00);
		// 操作工号
		czjl.put("CZGH", req.getYgdm());
		// 操作IP
		czjl.put("CZIP", ip);
		// 操作时间
		czjl.put("CZSJ", DateUtil.date().toTimestamp());
		// 病人ID
		czjl.put("BRID", ObjectToTypes.parseLong(kpxx.get("BRID")));
		czjl.put("LASTKNYE", kpxx.get("KNYE"));
		OpCzjl opCzjl = BeanUtil.fillBeanWithMapIgnoreCase(czjl, new OpCzjl(), true);
		opCzjl.setCzxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_CZJL));
		opCzjlDao.insert(opCzjl);
	}

	/**
	 * 操作记录查询
	 * 
	 * @param cardNo
	 * @return
	 */
	public List<OpCzjlResp> doQueryCzjlList(String cardNo) {
		OpCzjl czjl = new OpCzjl();
		czjl.setCardno(cardNo);
		List<OpCzjlResp> opCzjl = opCzjlDao.doQueryCzjlList(czjl);
		return opCzjl;
	}

	public List<OpCzFkxxResp> doQueryCzFkxxList(OpCzFkxxReq opCzFkxxReq) {
		return opCzFkxxDao.doQueryCzFkxxList(opCzFkxxReq);
	}

	public MpiKpxxPrintFpResp doPrintFpxx(Integer jlxh) {
		return opCzFkxxDao.doPrintFpxx(jlxh);
	}
}
