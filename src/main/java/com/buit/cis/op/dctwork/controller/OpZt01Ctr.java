
package com.buit.cis.op.dctwork.controller;

import com.buit.cis.op.dctwork.service.OpZt01Ser;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.enums.StopFlagEnum;
import com.buit.commons.model.OpZt01;
import com.buit.commons.request.OpZt01AddReq;
import com.buit.commons.request.OpZt01EditReq;
import com.buit.commons.request.OpZt01Req;
import com.buit.commons.response.OpZt01AllResp;
import com.buit.commons.response.OpZt01Resp;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 门诊_门诊医生组套 | 个人:YGDM值
科室:KSDM值
公用:NULL值<br>
 * @author 老花生
 */
@Api(tags="门诊医生组套")
@Controller
@RequestMapping("/opzt01")
public class OpZt01Ctr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(OpZt01Ctr.class);

    @Autowired
    private OpZt01Ser opZt01Ser;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OpZt01Resp>> queryPage(@Valid OpZt01Req req){
        PageInfo<OpZt01Resp> ret = opZt01Ser.query(req, getUser());
        return ReturnEntityUtil.success(ret);
    }


    /**
     * 启用
     */
    @RequestMapping("/enable")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value = "启用", httpMethod = "POST")
    public ReturnEntity<String> enable(@ApiParam(name = "ztbh", value = "组套编号", required = true) @RequestParam Integer ztbh) {
        opZt01Ser.enable(ztbh);
        return ReturnEntityUtil.success(StopFlagEnum.code_1.getCode());
    }

    /**
     * 停用
     */
    @RequestMapping("/stop")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value = "停用", httpMethod = "POST")
    public ReturnEntity<String> stop(@ApiParam(name = "ztbh", value = "组套编号", required = true) @RequestParam Integer ztbh) {
        opZt01Ser.stop(ztbh);
        return ReturnEntityUtil.success(StopFlagEnum.code_0.getCode());
    }


    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<Integer> add(@Valid OpZt01AddReq req) {
        req.setSfqy(Integer.parseInt(StopFlagEnum.code_0.getCode()));
        return ReturnEntityUtil.success(opZt01Ser.add(req, getUser()));
    }

    /** 医生工作站新增组套 */
    @RequestMapping("/addzt")
    @ResponseBody
    @ApiOperationSupport(author = "weijing")
    @ApiOperation(value="医生工作站新增组套" ,httpMethod="POST")
    public ReturnEntity addzt(@Valid @RequestBody OpZtAddReq req, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            logger.error(bindingResult.getFieldError().toString());
            return ReturnEntityUtil.error("error",bindingResult.getFieldError().getDefaultMessage());
        }

        opZt01Ser.addzt(req, getUser());
        return ReturnEntityUtil.success();
    }

    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity<OpZt01Resp> edit(@Valid OpZt01EditReq opZt01)  {
        opZt01Ser.edit(opZt01);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/queryMedicalStack")
    @ResponseBody
    @ApiOperation(value="住院药品医嘱组套查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OpZt01AllResp>> queryMedicalStack(@ApiParam(name = "ksdm", value = "科室代码", required = true)
                                                                   @RequestParam Integer ksdm ,@ApiParam(name = "pydm", value = "拼音代码", required = false)
                                                                   @RequestParam(value = "pydm", required = false )  String pydm, PageQuery page){
        PageInfo<OpZt01AllResp> opZt01AllRespPage = new PageInfo<>();
        PageInfo<OpZt01> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> opZt01Ser.getEntityMapper().queryMedicalStack(getUser().getUserId(),
                        ksdm, getUser().getHospitalId(), pydm)
        );
        opZt01AllRespPage.setTotal(pageInfo.getTotal());
        if(CollectionUtils.isNotEmpty(pageInfo.getList())) {
            Map<Integer, List<OpZt01>> groups = pageInfo.getList().stream().
                    collect(Collectors.groupingBy(OpZt01::getZtlb));
            OpZt01AllResp opZt01AllResp =  new OpZt01AllResp();
            opZt01AllResp.setWesternMedicineList(groups.get(1));
            opZt01AllResp.setChineseMedicineList(groups.get(2));
            opZt01AllResp.setHerbalMedicineList(groups.get(3));
            opZt01AllResp.setProjectList(groups.get(4));
            ArrayList<OpZt01AllResp> opZt01AllRespList = new ArrayList<OpZt01AllResp>();
            opZt01AllRespList.add(opZt01AllResp);
            opZt01AllRespPage.setList(opZt01AllRespList);
        }
        return ReturnEntityUtil.success(opZt01AllRespPage);
    }


    @RequestMapping("/queryProjectStack")
    @ResponseBody
    @ApiOperation(value="住院项目医嘱组套查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OpZt01>> queryProjectStack(@ApiParam(name = "type", value = "类型(1:本人,2:全院)", required = true)
                                                            @RequestParam Integer type ,@ApiParam(name = "pydm", value = "拼音代码", required = false)
                                                            @RequestParam(value = "pydm", required = false )  String pydm, PageQuery page){
        OpZt01 opZt01 = new OpZt01();
        opZt01.setPydm(pydm);
        opZt01.setSfqy(1);
        opZt01.setZtlb(4);
        opZt01.setJgid(getUser().getHospitalId());
        if(type == 1) {
            opZt01.setYgdm(getUser().getUserId());
            opZt01.setSslb(1);
        }else {
            opZt01.setSslb(3);
        }
        opZt01.setSortColumns("ZTLB,ZTBH");
        PageInfo<OpZt01> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> opZt01Ser.getEntityMapper().findByEntity(opZt01)
        );

        return ReturnEntityUtil.success(pageInfo);
    }

}

