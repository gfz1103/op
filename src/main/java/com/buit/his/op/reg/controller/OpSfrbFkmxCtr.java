
package com.buit.his.op.reg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buit.commons.BaseSpringController;
import com.buit.his.op.reg.service.OpSfrbFkmxSer;

import io.swagger.annotations.Api;

/**
 * 门诊_门诊收费日报付款明细<br>
 * 
 * @author WY
 */
@Api(tags = "门诊_门诊收费日报付款明细")
@Controller
@RequestMapping("/opsfrbfkmx")
public class OpSfrbFkmxCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpSfrbFkmxCtr.class);

	@Autowired
	private OpSfrbFkmxSer opSfrbFkmxSer;

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpSfrbFkmxResp>> queryPage(OpSfrbFkmxReq opsfrbfkmx,PageQuery page){
//        PageInfo<OpSfrbFkmx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> opSfrbFkmxSer.findByEntity(opsfrbfkmx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<OpSfrbFkmxResp>> getByEntity( OpSfrbFkmxReq opsfrbfkmx){//@RequestBody 
//        return ReturnEntityUtil.success(opSfrbFkmxSer.findByEntity(opsfrbfkmx));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpSfrbFkmxResp> getOneByEntity(OpSfrbFkmxReq opsfrbfkmx){
//        List<OpSfrbFkmx> list=opSfrbFkmxSer.findByEntity(opsfrbfkmx);
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
//    public ReturnEntity<OpSfrbFkmxResp> add(OpSfrbFkmxReq opSfrbFkmx) {
//        opSfrbFkmxSer.insert(opSfrbFkmx);        
//        return ReturnEntityUtil.success(opSfrbFkmx);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpSfrbFkmxResp> edit(OpSfrbFkmxReq opSfrbFkmx)  {
//        opSfrbFkmxSer.update(opSfrbFkmx);        
//        return ReturnEntityUtil.success(opSfrbFkmx);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpSfrbFkmxResp> delete(OpSfrbFkmxReq opSfrbFkmx) {
//        opSfrbFkmxSer.removeByEntity(opSfrbFkmx);        
//        return ReturnEntityUtil.success(opSfrbFkmx);            
//    }

}
