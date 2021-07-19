
package com.buit.his.op.infusion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buit.commons.BaseSpringController;
import com.buit.his.op.infusion.service.SkinDjmxSer;

import io.swagger.annotations.Api;

/**
 * <br>
 * 
 * @author WY
 */
@Api(tags = "皮试登记明细")
@Controller
@RequestMapping("/skindjmx")
public class SkinDjmxCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SkinDjmxCtr.class);

	@Autowired
	private SkinDjmxSer skinDjmxSer;

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SkinDjmxResp>> queryPage(SkinDjmxReq skindjmx,PageQuery page){
//        PageInfo<SkinDjmx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> skinDjmxSer.findByEntity(skindjmx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SkinDjmxResp>> getByEntity( SkinDjmxReq skindjmx){//@RequestBody 
//        return ReturnEntityUtil.success(skinDjmxSer.findByEntity(skindjmx));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SkinDjmxResp> getOneByEntity(SkinDjmxReq skindjmx){
//        List<SkinDjmx> list=skinDjmxSer.findByEntity(skindjmx);
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
//    public ReturnEntity<SkinDjmxResp> add(SkinDjmxReq skinDjmx) {
//        skinDjmxSer.insert(skinDjmx);        
//        return ReturnEntityUtil.success(skinDjmx);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SkinDjmxResp> edit(SkinDjmxReq skinDjmx)  {
//        skinDjmxSer.update(skinDjmx);        
//        return ReturnEntityUtil.success(skinDjmx);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SkinDjmxResp> delete(SkinDjmxReq skinDjmx) {
//        skinDjmxSer.removeByEntity(skinDjmx);        
//        return ReturnEntityUtil.success(skinDjmx);            
//    }

}
