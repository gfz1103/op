package com.buit.cis.op.dctwork.service.easemob.code;


/**
 * @Author sunjx
 * @Date 2021-01-25 09:36
 * @Description
 **/
public class EasemobConsts {
    /**
     * 环信用户类型
     */
    public enum EasemobUserType{
        USER(1),
        DOCTOR(2)
        ;
        private Integer key;

        EasemobUserType(Integer key) {
            this.key = key;
        }

        public Integer getKey() {
            return key;
        }

    }

    //账户状态（1禁用 2解禁）
    public enum activared{
        DISABLE("1"),
        LIFT("2")
        ;
        private String key;

        activared(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

    }

    /**
     * 咨询状态（1开始咨询 2结束咨询）
     */
    public enum ZXZT{
        START(1),
        FINISH(2)
        ;
        private Integer key;

        ZXZT(Integer key) {
            this.key = key;
        }

        public Integer getKey() {
            return key;
        }

    }

    /**
     * 用户类型（1客服 2医生）
     */
    public enum UserType{
        KF(1),
        YS(2)
        ;
        private Integer key;

        UserType(Integer key) {
            this.key = key;
        }

        public Integer getKey() {
            return key;
        }

    }
}
