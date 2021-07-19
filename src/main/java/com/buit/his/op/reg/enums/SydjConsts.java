package com.buit.his.op.reg.enums;

/**
 * @Author sunjx
 * @Date 2020-12-17 09:49
 * @Description
 **/
public class SydjConsts {

    /**
     * 输液注射状态
     */
    public enum SYDJZT{
        WAITTING("0", "待输液/注射"),
        ONGOING("1", "输液中"),
        FINISHED("2","完成输液/注射")
        ;
        private String key;
        private String desc;

        SYDJZT(String key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    /**
     * 科室类别
     */
    public enum KSLB{
        SHUYE("1", "输液"),
        ZHUSHE("2", "注射"),
        ;
        private String key;
        private String desc;

        KSLB(String key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
