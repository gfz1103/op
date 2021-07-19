
package com.buit.cis.op.dctwork.controller;

import com.buit.cis.op.dctwork.request.SysMacReq;
import com.buit.cis.op.dctwork.service.SysMacSer;
import com.buit.commons.BaseSpringController;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
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
 * MAC信息表(用于mac地址维护)<br>
 * @author 韦靖
 */
@Api(tags="MAC信息表(用于mac地址维护)")
@Controller
@RequestMapping("/sysmac")
public class SysMacCtr extends BaseSpringController{

    static final Logger logger = LoggerFactory.getLogger(SysMacCtr.class);

    @Autowired
    private SysMacSer sysMacSer;

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SysMacResp>> queryPage(SysMacReq sysmac,PageQuery page){
//        PageInfo<SysMac> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> sysMacSer.findByEntity(sysmac)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SysMacResp>> getByEntity( SysMacReq sysmac){//@RequestBody
//        return ReturnEntityUtil.success(sysMacSer.findByEntity(sysmac));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SysMacResp> getOneByEntity(SysMacReq sysmac){
//        List<SysMac> list=sysMacSer.findByEntity(sysmac);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));
//        }
//        return ReturnEntityUtil.success();
//    }
//
    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增mac与ip对应" ,httpMethod="POST")
    public ReturnEntity add(@Valid SysMacReq sysMac) {
        sysMac.setJgid(getUser().getHospitalId());
        sysMac.setIp(getIpAddress());
        sysMacSer.addMac(sysMac);
        return ReturnEntityUtil.success();
    }

    /** 查询当前客户端机器ip是否绑定过mac */
    @RequestMapping("/getMac")
    @ResponseBody
    @ApiOperation(value="查询当前客户端机器ip是否绑定过mac" ,httpMethod="POST")
    public ReturnEntity<Integer> getMacMessage() {
        Integer mac = sysMacSer.getMac(getIpAddress(), getUser().getHospitalId());
        return ReturnEntityUtil.success(mac);
    }

//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SysMacResp> edit(SysMacReq sysMac)  {
//        sysMacSer.update(sysMac);
//        return ReturnEntityUtil.success(sysMac);
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SysMacResp> delete(SysMacReq sysMac) {
//        sysMacSer.removeByEntity(sysMac);
//        return ReturnEntityUtil.success(sysMac);
//    }

}

