
package com.buit.cis.op.dctwork.controller;


import com.buit.apply.request.QueryYjyyDataReq;
import com.buit.apply.request.YjyySaveReq;
import com.buit.apply.response.QueryYysjViewResp;
import com.buit.apply.service.Cisjcsqd01Service;
import com.buit.apply.service.OpSbhyService;
import com.buit.cis.op.dctwork.request.DicZlxmQueryReq;
import com.buit.cis.op.dctwork.request.DicZlxmRecentTimeReq;
import com.buit.cis.op.dctwork.request.JySqdReq;
import com.buit.cis.op.dctwork.response.DicZlxmQueryResp;
import com.buit.cis.op.dctwork.response.DicZlxmRecentTimeResp;
import com.buit.cis.op.dctwork.service.DicZlxmSer;
import com.buit.commons.BaseSpringController;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 诊疗项目<br>
 *
 * @author 老花生
 */
@Api(tags = "门诊-检验")
@Controller
@RequestMapping("/diczlxm")
public class DicZlxmCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(DicZlxmCtr.class);

    @Autowired
    private DicZlxmSer dicZlxmSer;

    @DubboReference
    private Cisjcsqd01Service cisjcsqd01Service;

    @DubboReference
    private OpSbhyService opSbhyService;

    /**
     * 查询诊疗项目列表(sqdManageService.queryZlxmList)
     */
    @RequestMapping("/queryZlxmList")
    @ResponseBody
    @ApiOperation(value = "查询诊疗项目列表", httpMethod = "POST")
    public ReturnEntity<List<DicZlxmQueryResp>> queryZlxmList(DicZlxmQueryReq diczlxm) {//@RequestBody
        return ReturnEntityUtil.success(dicZlxmSer.queryZlxmList(diczlxm, getUser()));
    }

    /**
     * 查询设备指定日期最近的号源(sqdManageService.queryRecentTime)
     */
    @RequestMapping("/queryRecentTime")
    @ResponseBody
    @ApiOperation(value = "查询设备指定日期最近的号源", httpMethod = "POST")
    public ReturnEntity<DicZlxmRecentTimeResp> queryRecentTime(DicZlxmRecentTimeReq req) {//@RequestBody
        return ReturnEntityUtil.success(dicZlxmSer.queryRecentTime(req));
    }

    /**
     * 门诊或住院医技预约保存(sqdManageService.saveSqdFromMZorZY)
     */
    @RequestMapping("/saveSqdFromMZorZY")
    @ResponseBody
    @ApiOperation(value = "门诊或住院医技预约保存", httpMethod = "POST")
    public ReturnEntity saveSqdFromMzorZy(YjyySaveReq req) {//@RequestBody
        cisjcsqd01Service.saveSqdFromMzorZy(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 医技取消(sqdManageService.cancelYjyy)
     */
    @RequestMapping("/cancelYjyy")
    @ResponseBody
    @ApiOperation(value = "医技取消", httpMethod = "POST")
    public ReturnEntity cancelYjyy(@ApiParam(name = "jcxh", value = "检查序号", required = true) @RequestParam Integer jcxh) {//@RequestBody
        cisjcsqd01Service.cancelYjyy(jcxh);
        return ReturnEntityUtil.success();
    }

    /**
     * 查询诊间医技预约时间View数据(sqdManageService.queryYysjView)
     */
    @RequestMapping("/queryYysjView")
    @ResponseBody
    @ApiOperation(value = "查询诊间医技预约时间View数据", httpMethod = "POST")
    public ReturnEntity<List<QueryYysjViewResp>> queryYysjView(@ApiParam(name = "hyrq", value = "号源日期", required = true) @RequestParam String hyrq,
                                                               @ApiParam(name = "jclx", value = "检查类型", required = true) @RequestParam Integer jclx,
                                                               @ApiParam(name = "hysj", value = "号源时间") @RequestParam(required = false) String hysj) throws Exception {
        List<QueryYysjViewResp> resp = opSbhyService.queryYysjView(hyrq, jclx,hysj);
        return ReturnEntityUtil.success(resp);
    }

    /**
     * 医技预约数据加载(sqdManageService.queryYjyyData)
     */
    @RequestMapping("/queryYjyyData")
    @ResponseBody
    @ApiOperation(value = "医技预约数据加载", httpMethod = "POST")
    public ReturnEntity<Map<String, Object>> queryYjyyData(QueryYjyyDataReq req) {
        return ReturnEntityUtil.success(dicZlxmSer.queryYjyyData(req));
    }

    /**
     * 查询诊间医技预病html组装(sqdManageService.queryYjyy4Html)  QueryYysjViewResp
     */
    @RequestMapping("/queryYjyy4Html")
    @ResponseBody
    @ApiOperation(value = "查询诊间医技预病html组装", httpMethod = "POST")
    public ReturnEntity<Map<String, Object>> queryYjyy4Html() {
        return ReturnEntityUtil.success(dicZlxmSer.queryYjyy4Html());
    }

    /**
     * 保存门诊检验申请单(sqdManageService.saveMzJySqd)
     */
    @RequestMapping("/saveMzjySqd")
    @ResponseBody
    @ApiOperation(value = "保存门诊检验申请单", httpMethod = "POST")
    public ReturnEntity saveMzJySqd(@Valid @RequestBody JySqdReq req) {//@RequestBody
        dicZlxmSer.saveMzJySqd(req, getUser());
        return ReturnEntityUtil.success();
    }

}

