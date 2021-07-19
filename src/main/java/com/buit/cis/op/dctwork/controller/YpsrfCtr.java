
package com.buit.cis.op.dctwork.controller;

import com.buit.cis.op.dctwork.request.CyFmJcReq;
import com.buit.cis.op.dctwork.request.QueryMzYsFjReq;
import com.buit.cis.op.dctwork.response.QueryMzYsFjResp;
import com.buit.cis.op.dctwork.service.FeeYlsfxmSer;
import com.buit.cis.op.dctwork.service.OpZt01Ser;
import com.buit.commons.BaseSpringController;
import com.buit.commons.request.OpZt01QueReq;
import com.buit.commons.response.OpZt01Resp;
import com.buit.commons.response.QueryMzYsFjZtResp;
import com.buit.system.request.DicGbsj02Model;
import com.buit.system.request.QueryFeeYlsfxmdjReq;
import com.buit.system.response.DicGbsj02Resp;
import com.buit.system.response.SrfFeeYlsfxmdjResp;
import com.buit.system.service.DicGbsj02Service;
import com.buit.system.service.FeeYlsfxmdjService;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


/**
 * 药品输入法<br>
 *
 * @author 神算子
 */
@Api(tags = "药品输入法")
@Controller
@RequestMapping("/ypsrf")
public class YpsrfCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(YpsrfCtr.class);

    @Autowired
    private FeeYlsfxmSer feeYlsfxmSer;
    @DubboReference
    private FeeYlsfxmdjService feeYlsfxmdjService;
    @Autowired
    private OpZt01Ser opZt01Ser;
    @DubboReference
    private DicGbsj02Service dicGbsj02Service;

    /**
     * 实现诊疗查询功能(门诊医生工作站-附检)
     * ClinicSearchModule
     */
    @RequestMapping("/queryMzYsFj")
    @ResponseBody
    @ApiOperation(value = "门诊医生工作站-辅检查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<QueryMzYsFjResp>> queryMzYsFj(QueryMzYsFjReq req) {
        PageInfo<QueryMzYsFjResp> resp = feeYlsfxmSer.queryMzYsFj(req, getUser());
        return ReturnEntityUtil.success(resp);
    }

    /**
     * 实现诊疗查询功能(门诊医生工作站-附检-组套)
     * ClinicSearchModule
     */
    @RequestMapping("/queryMzYsFjZt")
    @ResponseBody
    @ApiOperation(value = "门诊医生工作站-辅检查询-组套", httpMethod = "POST")
    public ReturnEntity<PageInfo<QueryMzYsFjZtResp>> queryMzYsFjZt(QueryMzYsFjReq req){
        PageInfo<QueryMzYsFjZtResp> resp = feeYlsfxmSer.queryMzYsFjZt(req, getUser());
        return ReturnEntityUtil.success(resp);
    }

    /**
     * 检验 输入法查询
     * MedicineSetBQSearchModule
     * drugType.equals("4")
     * 住院医生角色  组套维护
     */
    @RequestMapping("/queryFeeYlsfxmdj")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "检验 输入法查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<SrfFeeYlsfxmdjResp>> queryFeeYlsfxmdj(@Valid QueryFeeYlsfxmdjReq req) {
//    	if("**".equals(req.getPydm())) {
//        	req.setPydm(null);
//        }
        if(req.getNoJc()!=null&&!req.getNoJc().equals(0)) {
            req.setNoJc(null);
        }
        req.setJgid(getUser().getHospitalId());
        PageInfo<SrfFeeYlsfxmdjResp> page = feeYlsfxmdjService.querySrfJy(req);
        return ReturnEntityUtil.success(page);
    }

    /** MedicineSearchModule*/
    @RequestMapping("/ztsrf")
    @ResponseBody
    @ApiOperation(value="组套输入法" ,notes = "开处方 时的组套输入法",httpMethod="POST")
    public ReturnEntity<PageInfo<OpZt01Resp>> ztsrf(OpZt01QueReq opzt01){
        opzt01.setJgid(getUser().getHospitalId());
        PageInfo<OpZt01Resp> pageInfo = PageHelper.startPage(opzt01.getPageNum(), opzt01.getPageSize())
                .doSelectPageInfo(() -> opZt01Ser.getEntityMapper().ztsrf(opzt01));

        return ReturnEntityUtil.success(pageInfo);
    }

    /** CYZDSearchModule*/
    @RequestMapping("/cyFmJc")
    @ResponseBody
    @ApiOperation(value="草药房名、煎法(825煎法、824方明)" ,httpMethod="POST")
    public ReturnEntity<PageInfo<DicGbsj02Resp>> cyFmJc(@Valid CyFmJcReq req){
        DicGbsj02Model dic = BeanUtil.toBean(req, DicGbsj02Model.class);
        PageInfo<DicGbsj02Resp> pageInfo = dicGbsj02Service.queryDicBgsj02(dic);
        return ReturnEntityUtil.success(pageInfo);
    }
}

