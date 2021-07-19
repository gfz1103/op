
package com.buit.cis.op.dctwork.controller;

import com.buit.commons.BaseSpringController;
import com.buit.system.request.SysXtcsReq;
import com.buit.system.response.SysXtcsResp;
import com.buit.system.service.SysXtcsSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 公用_系统参数<br>
 *
 * @author 老花生
 */
@Api(tags = "发药药房设置")
@Controller
@RequestMapping("/sysxtcs")
public class SysXtcsCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(SysXtcsCtr.class);

    @DubboReference
    private SysXtcsSer sysXtcsSer;


    @RequestMapping("/load")
	@ResponseBody
	@ApiOperationSupport(author = "老花生")
	@ApiOperation(value = "加载信息(原方法类OutPharmacyLoad)", httpMethod = "POST")
	public ReturnEntity<SysXtcsResp> load(
			@ApiParam(name = "pkey", value = "科室key", required = true) @RequestParam String pkey,
			@ApiParam(name = "ztbh", value = "组套编号") @RequestParam(value = "ztbh",required = false) Integer ztbh) {// @RequestBody

        return ReturnEntityUtil.success(sysXtcsSer.load(pkey, getUser().getHospitalId() ,ztbh));
	}

    @RequestMapping("/save")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value = "保存设置(原方法类OutPharmacySave)", httpMethod = "POST")
    public ReturnEntity<SysXtcsResp> save(@Valid SysXtcsReq req) {//@RequestBody
        sysXtcsSer.save(req, getUser().getHospitalId());
        return ReturnEntityUtil.success();
    }

}

