
package com.buit.cis.op.dctwork.controller;


import com.buit.cis.op.dctwork.service.OpYsJzlsSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.request.OpYsJzlsListReq;
import com.buit.commons.response.OpYsJzlsListResp;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 门诊_就诊历史<br>
 * @author 老花生
 */
@Api(tags="门诊_就诊历史")
@Controller
@RequestMapping("/opysjzls")
public class OpYsJzlsCtr extends BaseSpringController {
    
    static final Logger logger = LoggerFactory.getLogger(OpYsJzlsCtr.class);
    
    @Autowired
    private OpYsJzlsSer opYsJzlsSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpYsJzlsResp>> queryPage(OpYsJzlsReq opysjzls,PageQuery page){
//        PageInfo<OpYsJzls> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> opYsJzlsSer.findByEntity(opysjzls)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }

    /** 就诊记录 */
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="就诊记录" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OpYsJzlsListResp>> getList(@Valid OpYsJzlsListReq req){//@RequestBody
        return ReturnEntityUtil.success(opYsJzlsSer.getList(req, getUser()));
    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpYsJzlsResp> getOneByEntity(OpYsJzlsReq opysjzls){
//        List<OpYsJzls> list=opYsJzlsSer.findByEntity(opysjzls);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    
//    /** 新增 */
//    @RequestMapping("/add")
//    @ResponseBody
//    @ApiOperation(value="新增" ,httpMethod="POST")
//    public ReturnEntity<OpYsJzlsResp> add(OpYsJzlsReq opYsJzls) {
//        opYsJzlsSer.insert(opYsJzls);        
//        return ReturnEntityUtil.success(opYsJzls);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpYsJzlsResp> edit(OpYsJzlsReq opYsJzls)  {
//        opYsJzlsSer.update(opYsJzls);        
//        return ReturnEntityUtil.success(opYsJzls);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpYsJzlsResp> delete(OpYsJzlsReq opYsJzls) {
//        opYsJzlsSer.removeByEntity(opYsJzls);        
//        return ReturnEntityUtil.success(opYsJzls);            
//    }
    
}

