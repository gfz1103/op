
package com.buit.cis.op.dctwork.controller;

import com.buit.apply.response.OpZt02Resp;
import com.buit.cis.op.dctwork.service.OpZt02Ser;
import com.buit.commons.BaseSpringController;
import com.buit.commons.request.OpZt02AddReq;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 门诊_门诊医生组套明细<br>
 * @author 老花生
 */
@Api(tags="门诊医生组套明细")
@Controller
@RequestMapping("/opzt02")
public class OpZt02Ctr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(OpZt02Ctr.class);

    @Autowired
    private OpZt02Ser opZt02Ser;

    @RequestMapping("/findListByZtbh")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="按组套编号-返回列表(西药、成药、草要))" ,httpMethod="POST")
    public ReturnEntity<List<OpZt02Resp>> findListByZtbh(@ApiParam(name = "ztbh", value = "组套编号", required = true) @RequestParam Integer ztbh,
                                                         @ApiParam(name = "ztlb", value = "组套类型:1-西药,2-中成药,2-中草药", required = true) @RequestParam Integer ztlb,
                                                         @ApiParam(name = "ksid", value = "科室id", required = true) @RequestParam String ksid) {//@RequestBody
        Integer jgid = getUser().getHospitalId();
        return ReturnEntityUtil.success(opZt02Ser.qeury(ztbh, ztlb, jgid, ksid));
    }

//    @RequestMapping("/findPageByZtbh")
//    @ResponseBody
//    @ApiOperationSupport(author = "老花生")
//    @ApiOperation(value="按组套编号-返回分页(西药、成药、草要))" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpZt02Resp>> findPageByZtbh(@ApiParam(name = "ztbh", value = "组套编号", required = true) @RequestParam Integer ztbh,
//                                                             @ApiParam(name = "ztlb", value = "组套类型", required = true) @RequestParam Integer ztlb,
//                                                             @ApiParam(name = "ksid", value = "科室id", required = true) @RequestParam String ksid,
//                                                             PageQuery page){//@RequestBody
//        Integer jgid = getUser().getHospitalId();
//        PageInfo<OpZt02Resp> pageInfo = PageHelper.startPage(
//                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                () -> opZt02Ser.qeury(ztbh, ztlb, jgid, ksid));
//        return ReturnEntityUtil.success(pageInfo);
//    }

    @RequestMapping("/findListByZtbhXm")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="按组套编号-返回列表(项目)" ,httpMethod="POST")
    public ReturnEntity<List<OpZt02Resp>> findListByZtbhXm(@ApiParam(name = "ztbh", value = "组套编号", required = true) @RequestParam Integer ztbh){//@RequestBody
        return ReturnEntityUtil.success(opZt02Ser.qeuryXm(ztbh));
    }

//    @RequestMapping("/findPageByZtbhXm")
//    @ResponseBody
//    @ApiOperationSupport(author = "老花生")
//    @ApiOperation(value="按组套编号-返回分页(项目)" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpZt02Resp>> findPageByZtbhXm(@ApiParam(name = "ztbh", value = "组套编号", required = true) @RequestParam Integer ztbh, PageQuery page){//@RequestBody
//        PageInfo<OpZt02Resp> pageInfo = PageHelper.startPage(
//                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                () -> opZt02Ser.qeuryXm(ztbh));
//        return ReturnEntityUtil.success(pageInfo);
//    }

    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity add(@RequestBody List<OpZt02AddReq> req) {
        opZt02Ser.add(req);
        return ReturnEntityUtil.success();
    }

    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="删除" ,httpMethod="POST")
    public ReturnEntity delete(@ApiParam(name = "jlbh", value = "记录编号", required = true) @RequestParam Integer jlbh) {
        opZt02Ser.deleteById(jlbh);
        return ReturnEntityUtil.success();
    }

}

