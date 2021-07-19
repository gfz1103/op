
package com.buit.ecis.pretriage.controller;


import com.buit.commons.BaseSpringController;
import com.buit.ecis.pretriage.model.ErPreLyfs;
import com.buit.ecis.pretriage.request.ErPreLyfsReq;
import com.buit.ecis.pretriage.request.ErPreLyfsUpdateInfoReq;
import com.buit.ecis.pretriage.request.ErPreLyfsUpdateZtReq;
import com.buit.ecis.pretriage.response.ErPreLyfsResp;
import com.buit.ecis.pretriage.service.ErPreLyfsSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 来院方式<br>
 * @author 朱智
 */
@Api(tags="来院方式")
@Controller
@RequestMapping("/erprelyfs")
public class ErPreLyfsCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(ErPreLyfsCtr.class);
    
    @Autowired
    private ErPreLyfsSer erPreLyfsSer;

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="查询列表" ,httpMethod="POST")
    public ReturnEntity<List<ErPreLyfsResp>> getByEntity(){//@RequestBody
        ErPreLyfs erprelyfs = new ErPreLyfs();
        erprelyfs.setJgid(getUser().getHospitalId());
        List<ErPreLyfs> list = erPreLyfsSer.findByEntity(erprelyfs);
        List<ErPreLyfsResp> ret = BeanUtil.toBeans(list, ErPreLyfsResp.class);
        return ReturnEntityUtil.success(ret);
    }

    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除" ,httpMethod="POST")
    public ReturnEntity delete(@ApiParam(name = "lyfsid", value = "来院方式ID", required = true) @RequestParam Integer lyfsid) {
        erPreLyfsSer.getEntityMapper().deleteById(lyfsid);
        return ReturnEntityUtil.success();
    }

    /** 编辑状态 */
    @RequestMapping("/editZt")
    @ResponseBody
    @ApiOperation(value="编辑状态" ,httpMethod="POST")
    public ReturnEntity<ErPreLyfsResp> editZt(@Valid ErPreLyfsUpdateZtReq erPreLyfs)  {
        erPreLyfsSer.getEntityMapper().updateZt(erPreLyfs);
        return ReturnEntityUtil.success();
    }

    /** 编辑信息 */
    @RequestMapping("/editInfo")
    @ResponseBody
    @ApiOperation(value="编辑状态" ,httpMethod="POST")
    public ReturnEntity<ErPreLyfsResp> editZt(@Valid ErPreLyfsUpdateInfoReq erPreLyfs)  {
        erPreLyfsSer.getEntityMapper().updateInfo(erPreLyfs);
        return ReturnEntityUtil.success();
    }

    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<ErPreLyfsResp> add(@Valid ErPreLyfsReq erPreLyfs) {
        erPreLyfs.setJgid(getUser().getHospitalId());
        erPreLyfsSer.add(erPreLyfs);
        return ReturnEntityUtil.success();
    }
    
}

