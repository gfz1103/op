package com.buit.commons.dto;

import com.buit.commons.model.MpiCard;
import com.buit.commons.response.QueryDjDetailResp;
import com.buit.commons.response.QueryPaymentResp;
import com.buit.op.model.OpGhmx;

import java.util.List;

public class MphisCfjsDto {

    private MpiCard mpiCard;
    private OpGhmx opGhmx;
    private QueryPaymentResp queryPaymentResp;
    private List<QueryDjDetailResp> queryDjDetailRespList;


    public MpiCard getMpiCard() {
        return mpiCard;
    }

    public void setMpiCard(MpiCard mpiCard) {
        this.mpiCard = mpiCard;
    }

    public OpGhmx getOpGhmx() {
        return opGhmx;
    }

    public void setOpGhmx(OpGhmx opGhmx) {
        this.opGhmx = opGhmx;
    }

    public QueryPaymentResp getQueryPaymentResp() {
        return queryPaymentResp;
    }

    public void setQueryPaymentResp(QueryPaymentResp queryPaymentResp) {
        this.queryPaymentResp = queryPaymentResp;
    }

    public List<QueryDjDetailResp> getQueryDjDetailRespList() {
        return queryDjDetailRespList;
    }

    public void setQueryDjDetailRespList(List<QueryDjDetailResp> queryDjDetailRespList) {
        this.queryDjDetailRespList = queryDjDetailRespList;
    }
}
