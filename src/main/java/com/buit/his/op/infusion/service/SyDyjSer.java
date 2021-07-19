package com.buit.his.op.infusion.service;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.dao.SyDyjDao;
import com.buit.commons.model.SyDyj;
import com.buit.commons.response.SyDyjResp;

/**
 * 打印机<br>
 * 
 * @author WY
 */
@Service
public class SyDyjSer extends BaseManagerImp<SyDyj, Integer> {

	static final Logger logger = LoggerFactory.getLogger(SyDyjSer.class);

	@Autowired
	private SyDyjDao syDyjDao;

	@Override
	public SyDyjDao getEntityMapper() {
		return syDyjDao;
	}

	/**
	 * 输液瓶贴打印机列表
	 * 
	 * @param ksdm
	 * @return
	 */
	public List<SyDyjResp> doQuerySyptdyj(Integer ksdm, Integer jgid) {
		List<SyDyjResp> dyjList = syDyjDao.doQuerySyptdyj(ksdm, jgid);
		// 未设置打印机查询附近打印机列表
		if (dyjList == null || dyjList.isEmpty()) {
			dyjList = new ArrayList<SyDyjResp>();
			HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
			// 查找所有的可用的打印服务
			PrintService[] printService = PrintServiceLookup.lookupPrintServices(flavor, pras);
			for (int i = 0; i < printService.length; i++) {
				SyDyjResp syDyjResp = new SyDyjResp();
				syDyjResp.setJgid(jgid);
				syDyjResp.setPtdyj(printService[i].getName());
				dyjList.add(syDyjResp);
			}
		}
		return dyjList;
	}

	/**
	 * 输液巡回单打印机列表
	 * 
	 * @param ksdm
	 * @param jgid
	 * @return
	 */
	public List<SyDyjResp> doQuerySyxhddyj(Integer ksdm, Integer jgid) {
		List<SyDyjResp> dyjList = syDyjDao.doQuerySyxhddyj(ksdm, jgid);
		// 未设置打印机查询附近打印机列表
		if (dyjList == null || dyjList.isEmpty()) {
			dyjList = new ArrayList<SyDyjResp>();
			HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
			// 查找所有的可用的打印服务
			PrintService[] printService = PrintServiceLookup.lookupPrintServices(flavor, pras);
			for (int i = 0; i < printService.length; i++) {
				SyDyjResp syDyjResp = new SyDyjResp();
				syDyjResp.setJgid(jgid);
				syDyjResp.setXhddyj(printService[i].getName());
				dyjList.add(syDyjResp);
			}
		}
		return dyjList;
	}

	/**
	 * 输液瓶贴或巡回单打印机保存或修改
	 * 
	 * @param syDyj
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveOrUpdateSydyj(SyDyj syDyj) {
		Integer ptdyjCount = syDyjDao.doQuerySyptdyjCount(syDyj);
		if (ptdyjCount != null && ptdyjCount.intValue() == 0) {
			syDyj.setXhddyj(null);
			syDyjDao.insert(syDyj);
		}
		Integer xhddyjCount = syDyjDao.doQuerySyxhddyjCount(syDyj);
		if (xhddyjCount != null && xhddyjCount.intValue() == 0) {
			syDyj.setPtdyj(null);
			syDyjDao.insert(syDyj);
		}

	}

}
