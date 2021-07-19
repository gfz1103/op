package com.buit.cis.op.dctwork.service.mkey.sign;


public class DoctorMkeySignServiceConsts {

    //签名业务类型
    public enum DoctorMkeyDataServiceType{
        LOGIN(1, "登录"),
        SIGN(2, "处方签名"),
        ;
        private Integer value;
        private String desc;

        DoctorMkeyDataServiceType(Integer value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public Integer getValue() {
            return value;
        }

        public String getDesc() {
            return desc;
        }

        public static DoctorMkeyDataServiceType getByValue(Integer value){
            for (DoctorMkeyDataServiceType type : DoctorMkeyDataServiceType.values()) {
                if(type.getValue() == value){
                    return type;
                }
            }
            return null;
        }
    }
}
