
package com.buit.cis.op.dctwork.controller;

import com.buit.cis.op.dctwork.service.LisJyztlxSer;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.model.LisJyztlx;
import com.buit.commons.request.LisJyztlxEditReq;
import com.buit.commons.request.LisJyztlxReq;
import com.buit.commons.response.LisJyztlxResp;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * 组套类型维护<br>
 * @author 老花生
 */
@Api(tags="检验组套维护--主")
@Controller
@RequestMapping("/lisjyztlx")
public class LisJyztlxCtr extends BaseSpringController {
    
    static final Logger logger = LoggerFactory.getLogger(LisJyztlxCtr.class);
    
    @Autowired
    private LisJyztlxSer lisJyztlxSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<LisJyztlxResp>> queryPage(PageQuery page){
        LisJyztlx lisjyztlx = BeanUtil.toBean(page, LisJyztlx.class);
        lisjyztlx.setZxbz("0");
        lisjyztlx.setSortColumns(" id asc ");
        PageInfo<LisJyztlx> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> lisJyztlxSer.findByEntity(lisjyztlx)
            );
        return ReturnEntityUtil.success(BeanUtil.toPage(pageInfo, LisJyztlxResp.class));
    }

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
    public ReturnEntity<List<LisJyztlxResp>> getByEntity(LisJyztlxReq req){//@RequestBody
        LisJyztlx lisjyztlx = BeanUtil.toBean(req, LisJyztlx.class);
        lisjyztlx.setZxbz("0");
        lisjyztlx.setSortColumns(" id asc ");
        List<LisJyztlx> list = lisJyztlxSer.findByEntity(lisjyztlx);
        return ReturnEntityUtil.success(BeanUtil.toBeans(list, LisJyztlxResp.class));
    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<LisJyztlxResp> getOneByEntity(LisJyztlxReq lisjyztlx){
//        List<LisJyztlx> list=lisJyztlxSer.findByEntity(lisjyztlx);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }

    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity add(@Valid LisJyztlxReq lisJyztlx) {
        lisJyztlxSer.add(lisJyztlx);
        return ReturnEntityUtil.success();
    }
    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity edit(LisJyztlxEditReq lisJyztlx)  {
        lisJyztlxSer.update(lisJyztlx);
        return ReturnEntityUtil.success();
    }


    /** 注销(saveLogoutZtlx) */
    @RequestMapping("/saveLogoutZtlx")
    @ResponseBody
    @ApiOperation(value="注销" ,httpMethod="POST")
    public ReturnEntity saveLogoutZtlx(@ApiParam(name = "id", value = "主键", required = true) @RequestParam Integer id)  {
        lisJyztlxSer.saveLogoutZtlx(id);
        return ReturnEntityUtil.success();
    }

//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<LisJyztlxResp> delete(LisJyztlxReq lisJyztlx) {
//        lisJyztlxSer.removeByEntity(lisJyztlx);        
//        return ReturnEntityUtil.success(lisJyztlx);            
//    }
    
}

