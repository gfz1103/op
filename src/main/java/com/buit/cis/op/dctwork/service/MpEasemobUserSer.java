package com.buit.cis.op.dctwork.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.cis.op.dctwork.request.MpEasemobUserAddReq;
import com.buit.cis.op.dctwork.request.MpEasemobUserReq;
import com.buit.cis.op.dctwork.response.MpEasemobUserResp;
import com.buit.cis.op.dctwork.service.easemob.code.EasemobConsts;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.commons.dao.MpEasemobUserDao;
import com.buit.commons.enums.StatusEnum;
import com.buit.commons.model.MpEasemobUser;
import com.buit.constans.TableName;
import com.buit.op.request.RegUserRequest;
import com.buit.op.response.EasemobResponse;
import com.buit.op.response.UserInfoResponse;
import com.buit.op.service.mphis.MphisOpService;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 环信用户表（客服使用）<br>
 * @author 韦靖
 */
@Service
public class MpEasemobUserSer extends BaseManagerImp<MpEasemobUser,Long> {

    static final Logger logger = LoggerFactory.getLogger(MpEasemobUserSer.class);

    @Autowired
    private MpEasemobUserDao mpEasemobUserDao;

    @Autowired
    public RedisFactory redisFactory;

    @Autowired
    private Snowflake snowflake;

    @Autowired
    private MpUserConsultSer mpUserConsultSer;

    @DubboReference
    private MphisOpService mphisOpService;

    @Override
    public MpEasemobUserDao getEntityMapper(){
        return mpEasemobUserDao;
    }

    //查询环信账号列表
    public List<MpEasemobUserResp> queryEasemobUser(MpEasemobUserReq req){
        List<MpEasemobUser> easemobUsers = mpEasemobUserDao.queryEasemobUser(BeanUtil.toBean(req, MpEasemobUser.class));
        if (CollUtil.isEmpty(easemobUsers)){
            return null;
        }

        List<MpEasemobUserResp> resps = easemobUsers.stream().map(o -> BeanUtil.toBean(o, MpEasemobUserResp.class)).collect(Collectors.toList());

        return resps;
    }


    /**
     * 新增环信账户信息
     */
    @Transactional(rollbackFor = Exception.class)
    public MpEasemobUser insertEasemobUser(MpEasemobUserAddReq addReq, SysUser sysUser){
        //判断用户是否已经存在有效账号
        easemobIsExit(addReq.getUserid());

        //当用户名和密码不传时系统自动生成
        if (StrUtil.isBlank(addReq.getUsername())){
            addReq.setUsername(String.valueOf(snowflake.nextId()));
        }
        if (StrUtil.isBlank(addReq.getPassword())){
            addReq.setPassword(RandomUtil.randomString(8));
        }

        //注册环信账户信息
        RegUserRequest request = BeanUtil.toBean(addReq, RegUserRequest.class);
        EasemobResponse<UserInfoResponse, Object> easemobs = mphisOpService.regUser(request);
        List<UserInfoResponse> easemob = easemobs.getEntities();
        if (CollUtil.isEmpty(easemob)){
            throw BaseException.create("ERROR_EASEMOB_0024");
        }

        UserInfoResponse infoResponse = easemob.get(0);

        //新增环信用户表数据
        MpEasemobUser easemobUser = new MpEasemobUser();
        easemobUser.setId(Long.valueOf(redisFactory.getTableKey(TableName.DB_NAME, TableName.MP_EASEMOB_USER)));
        easemobUser.setState(StatusEnum.State.ENABLED.getCode());
        easemobUser.setUserid(addReq.getUserid());
        easemobUser.setCreateUserId(Long.valueOf(sysUser.getUserId()));
        easemobUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
        easemobUser.setUpdateUserId(Long.valueOf(sysUser.getUserId()));
        easemobUser.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        easemobUser.setActivated(infoResponse.getActivated());
        easemobUser.setNickname(infoResponse.getNickname());
        easemobUser.setCreated(infoResponse.getCreated());
        easemobUser.setModified(infoResponse.getModified());
        easemobUser.setType(infoResponse.getType());
        easemobUser.setUsername(infoResponse.getUsername());
        easemobUser.setPassword(addReq.getPassword());
        easemobUser.setUsertype(addReq.getUsertype());//用户类型 新增
        easemobUser.setUuid(infoResponse.getUuid());
        mpEasemobUserDao.insert(easemobUser);
        return easemobUser;
    }

    /**
     * 禁用与解禁
     * @param id
     * @param activated 1禁用 2解禁
     * @param sysUser
     */
    @Transactional(rollbackFor = Exception.class)
    public void disableOrLift(Long id,String activated,SysUser sysUser){
        //通过id查询账号详细信息
        MpEasemobUser easemobUser = mpEasemobUserDao.getById(id);
        if (easemobUser == null){
            throw BaseException.create("ERROR_EASEMOB_0022");
        }
        //禁用与解禁
        EasemobResponse<UserInfoResponse, Object> activate = null;
        if (EasemobConsts.activared.DISABLE.getKey().equals(activated)){
            activate  = mphisOpService.deactivate(easemobUser.getUsername());
        }else if (EasemobConsts.activared.LIFT.getKey().equals(activated)){
            activate = mphisOpService.activate(easemobUser.getUsername());
        }
        if (activate == null){
            throw BaseException.create("ERROR_EASEMOB_0026");
        }
        if ("activate user".equals(activate.getAction())){
            easemobUser.setActivated("true");
        }else if ("Deactivate user".equals(activate.getAction())){
            easemobUser.setActivated("false");
        }
        //List<UserInfoResponse> entities = activate.getEntities();
//        if (CollUtil.isEmpty(entities)){
//            throw BaseException.create("ERROR_EASEMOB_0022");
//        }
//        UserInfoResponse response = entities.get(0);

        //修改表状态
        //easemobUser.setActivated(response.getActivated());
        easemobUser.setUpdateUserId(Long.valueOf(sysUser.getUserId()));
        easemobUser.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        mpEasemobUserDao.updateZt(easemobUser);
    }

    //返回登录环信账号信息（如果账号被禁用 提示需要解禁方可进入；如果没有账号自动注册账号）
    @Transactional(rollbackFor = Exception.class)
    public MpEasemobUserResp getEasemobUser(SysUser sysUser){
        MpEasemobUser easemobUser = mpEasemobUserDao.easemobIsExit(String.valueOf(sysUser.getUserId()));
        MpEasemobUserResp resp = null;

        if (easemobUser == null){
            //无账号自动注册账号
            MpEasemobUserAddReq addReq = new MpEasemobUserAddReq();
            addReq.setNickname(String.valueOf(sysUser.getUserId()));
            addReq.setUsername(String.valueOf(snowflake.nextId()));
            addReq.setPassword(RandomUtil.randomString(8));
            addReq.setUserid(Long.valueOf(sysUser.getUserId()));
            addReq.setUsertype(String.valueOf(EasemobConsts.UserType.YS.getKey()));
            MpEasemobUser user = insertEasemobUser(addReq, sysUser);

            //返回账号信息
            resp = BeanUtil.toBean(user, MpEasemobUserResp.class);
        }else {
            if ("false".equals(easemobUser.getActivated())){
                throw BaseException.create("ERROR_EASEMOB_0027");
            }
            resp = BeanUtil.toBean(easemobUser, MpEasemobUserResp.class);
        }

        //账号密码加密
        resp.setUsername(Base64.encode(resp.getUsername()));
        resp.setPassword(Base64.encode(resp.getPassword()));
        return resp;
    }

    /**
     * 删除已经禁用的账号数据
     * @param easemobId
     */
    public void deleteEasemob(Long easemobId,SysUser sysUser){
        //查询到账号数据
        MpEasemobUser mpEasemobUser = mpEasemobUserDao.getById(easemobId);
        if (mpEasemobUser == null){
            throw BaseException.create("ERROR_HLWYY_0013");
        }
        //不能删除处于有效状态的数据
        if ("true".equals(mpEasemobUser.getActivated())){
            throw BaseException.create("ERROR_HLWYY_0014");
        }

        //逻辑删除数据
        mpEasemobUser.setState(StatusEnum.State.DELETED.getCode());
        mpEasemobUser.setUpdateUserId(Long.valueOf(sysUser.getUserId()));
        mpEasemobUser.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        mpEasemobUserDao.updateState(mpEasemobUser);
    }



    /**
     * 判断用户是否已经存在账号
     * @param userid
     */
    private void easemobIsExit(Long userid){
        MpEasemobUser easemobUser = mpEasemobUserDao.easemobIsExit(String.valueOf(userid));
        if (easemobUser != null){
            throw BaseException.create("ERROR_EASEMOB_0025");
        }
    }
}
