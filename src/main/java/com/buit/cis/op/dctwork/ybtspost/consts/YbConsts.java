package com.buit.cis.op.dctwork.ybtspost.consts;

/**
 * @Author weijing
 * @Date 2021-04-09 15:38
 * @Description
 **/
public class YbConsts {
    //触发点编码
    public enum Cfddm{
         CFDDM_1("3101","门诊就诊"),
         CFDDM_2("3102","门诊诊断"),
         CFDDM_3("3103","录入处方"),
         CFDDM_4("3104","保存处方"),
         url("3104","保存处方"),
        ;

        private String code;

        private String msg;

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        Cfddm(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
    public enum UrlEnum {
        //设置:默认标志 | 1.默认科室   0.非默认科室
        url("/basy/ybzntx");


        private String code;

        UrlEnum(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
