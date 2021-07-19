package com.buit.commons.dao;


import com.buit.commons.EntityDao;
import com.buit.commons.model.MpPsxx;
import com.buit.commons.request.MpPsxxReq;
import com.buit.commons.response.MpPsxxResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 互联网医院配送信息表<br>
 * @author DESKTOP-1OEG1QM
 */
@Mapper
public interface MpPsxxDao extends EntityDao<MpPsxx,Integer> {


    List<MpPsxxResp> getList(MpPsxxReq mpPsxxReq);


    void updateZtBycfsbList(@Param("list") List<Integer> cfsbList, @Param("psxx")MpPsxx  mpPsxx);
}
