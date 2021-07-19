package com.buit.cis.op.dctwork.service.mkey.consts;

public class Consts {

    /**
     * 数据逻辑删除状态
     */
    public enum Status{
        NOMAL(1,"正常"),
        LOGIC_DELETED(-1, "逻辑删除"),
        ;
        private int key;
        private String text;

        Status(int key, String text) {
            this.key = key;
            this.text = text;
        }

        public int getKey() {
            return key;
        }

        public String getText() {
            return text;
        }
    }

    /**
     * 环信用户类型
     */
    public enum EasemobUserType{
        DOCTOR(2,"医生"),
        PATIENT(3, "患者"),
        ;
        private int key;
        private String text;

        EasemobUserType(int key, String text) {
            this.key = key;
            this.text = text;
        }

        public int getKey() {
            return key;
        }

        public String getText() {
            return text;
        }
    }

    /**
     * 时间格式
     */
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String PATTERN_YY_MM_dd = "yyyy-MM-dd";

    /**
     * MDC
     */
    public static final String REQUESTID = "REQUESTID";
}
