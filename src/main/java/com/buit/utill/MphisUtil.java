package com.buit.utill;

import com.buit.commons.response.MsQryRegisterResp;
import com.buit.op.model.mphis.response.MphisGhfyResponse;
import com.buit.op.model.mphis.response.OpMphisProjectDto;
import com.buit.op.service.mphis.OpMphisProject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MphisUtil {


    /**
     * 暂时把图文、语音、视频费用设置为其他收费qtsf
     *
     * @param msQryRegisterResp
     * @param opMphisProject
     * @return mphisGhfyResponse
     */
    public static MphisGhfyResponse resetMphisGhfy(MsQryRegisterResp msQryRegisterResp, OpMphisProject opMphisProject){
        BigDecimal wzje = opMphisProject.getPrice();
        MphisGhfyResponse mphisGhfyResponse = BeanUtil.toBean(msQryRegisterResp, MphisGhfyResponse.class);
        //暂时不走医保
        mphisGhfyResponse.setQtys(BigDecimal.ZERO);
        mphisGhfyResponse.setYsk(mphisGhfyResponse.getYsk().add(wzje));
        mphisGhfyResponse.setZfje(mphisGhfyResponse.getZfje().add(wzje));
        mphisGhfyResponse.setZjje(mphisGhfyResponse.getZjje().add(wzje));
        mphisGhfyResponse.setWzje(wzje);
        mphisGhfyResponse.setGhje(new BigDecimal(msQryRegisterResp.getGhf()));
        mphisGhfyResponse.setZlje(new BigDecimal(msQryRegisterResp.getZlf()));
        mphisGhfyResponse.setZjf(new BigDecimal(msQryRegisterResp.getZjfy()));
        OpMphisProjectDto opMphisProjectDto = new OpMphisProjectDto();
        opMphisProjectDto.setCode(opMphisProject.getCode());
        opMphisProjectDto.setName(opMphisProject.getName());
        opMphisProjectDto.setPrice(opMphisProject.getPrice());
        mphisGhfyResponse.setOpMphisProject(opMphisProjectDto);
        return mphisGhfyResponse;
    }

    /**
     * 对象集合属性值拷贝
     * @param sources
     * @param target
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target){
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            cn.hutool.core.bean.BeanUtil.copyProperties(source, t);
            list.add(t);
        }
        return list;
    }
}
