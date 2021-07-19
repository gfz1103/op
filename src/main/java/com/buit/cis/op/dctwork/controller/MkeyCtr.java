package com.buit.cis.op.dctwork.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.json.JSONObject;
import com.buit.cis.op.dctwork.request.MkeyCreateSignQrcodeRequest;
import com.buit.cis.op.dctwork.response.LoginResponse;
import com.buit.cis.op.dctwork.response.MkeyCreateLoginQrcodeResponse;
import com.buit.cis.op.dctwork.response.MkeyCreateSignQrcodeResponse;
import com.buit.cis.op.dctwork.service.mkey.DoctorMkeyService;
import com.buit.cis.op.dctwork.service.mkey.sign.DoctorMkeySignServiceConsts;
import com.buit.commons.BaseException;
import com.buit.op.model.mphis.response.MkeyRecord;
import com.buit.op.service.CaAuthenticationService;
import com.buit.op.service.mphis.mkey.consts.Action;
import com.buit.op.service.mphis.mkey.consts.Mode;
import com.buit.op.service.mphis.mkey.consts.MsgWrap;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Mkey 接口
 */
@Api(tags = "Mkey接口")
@Controller
@RequestMapping("/qrcode")
public class MkeyCtr {
    static final Logger log = LoggerFactory.getLogger(MkeyCtr.class);

    @Autowired
    private DoctorMkeyService doctorMkeyService;

    @Autowired
    private Snowflake snowflake;

    @Autowired
    private CaAuthenticationService caAuthenticationService;

    @ApiOperation("mkey 生成登录二维码")
    @ResponseBody
    @PostMapping(value = "/login/create")
    public ReturnEntity<MkeyCreateLoginQrcodeResponse> loginQrcode(@Valid @RequestBody MkeyCreateSignQrcodeRequest request){
        String bizSn = snowflake.nextIdStr();
        String qrcode = doctorMkeyService.qrcode(
                bizSn,
                DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType.getByValue(request.getType()),
                request.getDataId(),
                Mode.REDIRECT,
                Action.LOGIN,
                MsgWrap.DEFAULT);
        MkeyCreateLoginQrcodeResponse response = new MkeyCreateLoginQrcodeResponse();
        response.setBizSn(bizSn);
        response.setQrcode(qrcode);
        return ReturnEntityUtil.success(response);
    }

    @ApiOperation(value = "mkey 扫码登录回调")
    @ResponseBody
    @PostMapping(value = "/login")
    public ReturnEntity loginCallBack(
            @RequestParam("bizSn")String bizSn,
            @RequestParam("action")String action,
            @RequestParam(value = "cert", required = false)String cert,
            @RequestParam(value = "signAlg", required = false)String signAlg,
            @RequestParam(value = "signValue", required = false)String signValue,
            @RequestParam(value = "id", required = false)String mkeyUserId){
        try {
            MkeyRecord record = doctorMkeyService.notify(bizSn, action, cert, signAlg, signValue, mkeyUserId, null, null);
            if (record == null) {
                return ReturnEntityUtil.success();
            }

            LoginResponse response = new LoginResponse();
            response.setId(record.getUserId() == null ? -1 : record.getUserId());
            return ReturnEntityUtil.success(response);
        } catch (BaseException e) {
            log.error("【mkey 扫码登录回调】出现异常 => bizSn:{}", bizSn, e);
            return ReturnEntityUtil.error(e.getMessage());
        } catch (Exception e){
            log.error("【mkey 扫码登录回调】出现未知异常 => bizSn:{}", bizSn, e);
            return ReturnEntityUtil.error(e.getMessage());
        }
    }

    @ApiOperation("mkey 生成签名二维码")
    @ResponseBody
    @PostMapping(value = "/sign/create")
    public ReturnEntity<MkeyCreateSignQrcodeResponse> signQrcode(@Valid @RequestBody MkeyCreateSignQrcodeRequest request){
        String bizSn = snowflake.nextIdStr();
        String qrcode = doctorMkeyService.qrcode(bizSn,
                DoctorMkeySignServiceConsts.DoctorMkeyDataServiceType.getByValue(request.getType()),
                request.getDataId(),
                Mode.REDIRECT,
                Action.SIGN,
                MsgWrap.DEFAULT);
        MkeyCreateSignQrcodeResponse response = new MkeyCreateSignQrcodeResponse();
        response.setBizSn(bizSn);
        response.setQrcode(qrcode);
        return ReturnEntityUtil.success(response);
    }

//    @ApiOperation(value = "mkey 签名回调",hidden = true)
//    @ResponseBody
//    @PostMapping(value = "/sign")
//    public ReturnEntity signCallBack(
//            @RequestParam("bizSn")String bizSn,
//            @RequestParam("action")String action,
//            @RequestParam(value = "cert", required = false)String cert,
//            @RequestParam(value = "signAlg", required = false)String signAlg,
//            @RequestParam(value = "signValue", required = false)String signValue,
//            @RequestParam(value = "id", required = false)String mkeyUserId){
//
//        log.debug("【mkey 签名回调】=> bizSn:{}, cert:{}, signAlg:{}, signValue:{}, id:{}", bizSn, cert, signAlg, signValue, mkeyUserId);
//
//        try {
//            doctorMkeyService.notify(bizSn, action, cert, signAlg, signValue, mkeyUserId, null, null);
//            return ReturnEntityUtil.success();
//        } catch (BaseException e) {
//            log.error("【mkey 签名回调】出现异常 => bizSn:{}", bizSn, e);
//            return ReturnEntityUtil.error(e.getMessage());
//        } catch (Exception e){
//            log.error("【mkey 签名回调】出现未知异常 => bizSn:{}", bizSn, e);
//            return ReturnEntityUtil.error(e.getMessage());
//        }
//    }

    /** 获取当前bizSn的扫码回调状态 */
    @RequestMapping("/getCallBackStatus")
    @ResponseBody
    @ApiOperation(value="获取当前bizSn的扫码回调状态" ,httpMethod="POST")
    public ReturnEntity<JSONObject> getCallBackStatus(@ApiParam(name = "bizSn", value = "bizSn", required = true) @RequestParam String bizSn)  {
        return ReturnEntityUtil.success(doctorMkeyService.getCallBackStatus(bizSn));
    }

//    /** 保存医生环信信息 */
//    @RequestMapping("/saveMkeyUser")
//    @ResponseBody
//    @ApiOperation(value="保存医生环信信息" ,httpMethod="POST")
//    public ReturnEntity saveMkeyUser(@RequestBody MkeyUserReq mkeyUserReq)  {
//        caAuthenticationService.saveMkeyUser(mkeyUserReq);
//        return ReturnEntityUtil.success();
//    }


//    /** 通过手机号获取员工CA证书序列号 */
//    @RequestMapping("/cazsxlh")
//    @ResponseBody
//    @ApiOperation(value="通过手机号获取员工CA证书序列号" ,httpMethod="POST")
//    public ReturnEntity<String> getCazsxlh(@ApiParam(name = "phone", value = "手机号", required = true) @RequestParam(value = "phone")String phone)  {
//        String ca = null;
//        try {
//            ca = caAuthenticationService.getCazsxlhByMkeyUser(phone);
//            if(Objects.isNull(ca)){
//                throw BaseException.create("ERROR_USER_0023");
//            }
//        }catch (BaseException e){
//            return ReturnEntityUtil.error(e.getCode(),e.getMessage());
//        }catch (Exception e){
//            return ReturnEntityUtil.error(e.getMessage());
//        }
//        return ReturnEntityUtil.success(ca);
//    }

}
