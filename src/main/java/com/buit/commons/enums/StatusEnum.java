package com.buit.commons.enums;

/**
 * @Author weijing
 * @Date 2020-11-30 09:33
 * @Description
 **/
public class StatusEnum {
    public enum Xmlx {
        /***项目类型 1：西药 2：成药3：草药 4检验,5检查,6手术,7治疗,8护理,9饮食,10卫材,11处置，99其他*/
        XY(1,"西药"),
        ZCY(2,"成药"),
        CY(3,"草药"),
        JY(4,"检验"),
        JC(5,"检查"),
        SS(6,"手术"),
        ZL(7,"治疗"),
        HL(8,"护理"),
        YS(9,"饮食"),
        WC(10,"卫材"),
        CZ(11,"处置"),
        OTHER(99,"其他"),
        ;
        /*** 字段key值*/
        private Integer code;

        /*** 字段文本值*/
        private String name;

        Xmlx(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    public enum Djzt {
        /***单据状态  0暂存，1提交，2预约，3已检查，4已报告，5已审核，6再审，7打印 9退回(与YS_JC01表JCZT值一致) 20.收费 21 退费*/
        ZC(0,"暂存"),
        TJ(1,"提交"),
        YY(2,"预约"),
        YJC(3,"已检查"),
        YBG(4,"已报告"),
        YSH(5,"已审核"),
        ZS(6,"再审"),
        DY(7,"打印"),
        TH(9,"退回"),
        SF(20,"收费"),
        TF(21,"退费"),
        ;
        /*** 字段key值*/
        private Integer code;

        /*** 字段文本值*/
        private String name;

        Djzt(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    public enum Sqzt {
        /***住院登记表（op_zydj）申请状态  1新申请2已提交3已入院*/
        XSQ("1","新申请"),
        YTJ("2","已提交"),
        YRY("3","已入院"),
        ;
        /*** 字段key值*/
        private String code;

        /*** 字段文本值*/
        private String name;

        Sqzt(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    public enum Sqlx {
        /***住院登记表（op_zydj）申请类型  1住院申请、2留观申请*/
        ZYSQ("1","住院申请"),
        LGSQ("2","留观申请"),
        ;
        /*** 字段key值*/
        private String code;

        /*** 字段文本值*/
        private String name;

        Sqlx(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }


    /**
     * 结束处理方式（1 结束就诊 2初始化就诊（将状态置为待就诊））
     */
    public enum DealType{
        JSJZ("1", "结束就诊"),
        CSHJZ("2", "初始化就诊"),
        ;
        private String code;
        private String val;

        DealType(String code, String val) {
            this.code = code;
            this.val = val;
        }

        public String getCode() {
            return code;
        }

        public String getVal() {
            return val;
        }
    }

    public enum State{
        DELETED(-1, "删除"),
        DISABLED(0, "禁用"),
        ENABLED(1, "有效"),
        ;
        private Integer code;
        private String val;

        State(Integer code, String val) {
            this.code = code;
            this.val = val;
        }

        public Integer getCode() {
            return code;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 皮试结果(0需要皮试；1无需皮试；2阴性；3阳性)
     */
    public enum Psjg{
        XYPS("0", "需要皮试"),
        WXPS("1", "无需皮试"),
        YINX("2", "阴性"),
        YANGX("3", "阳性"),
        ;
        private String code;
        private String val;

        Psjg(String code, String val) {
            this.code = code;
            this.val = val;
        }

        public String getCode() {
            return code;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 处方类型 1普通(普) 2精二处方(精) 3 儿科处方（儿） 4 麻、精一处方（麻、精一）
     */
    public enum Cflx{
        PT("1", "普"),
        JE("2", "精"),
        EK("3", "儿"),
        MJY("4", "麻、精一"),
        ;
        private String code;
        private String val;

        Cflx(String code, String val) {
            this.code = code;
            this.val = val;
        }

        public String getCode() {
            return code;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 单据类型 1病情证明单 2疾病证明单
     */
    public enum Djlx{
        BQZMD("1", "病情证明单"),
        JBZMD("2", "疾病证明单"),
        ;
        private String code;
        private String val;

        Djlx(String code, String val) {
            this.code = code;
            this.val = val;
        }

        public String getCode() {
            return code;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 单据来源 | 1医生开单 2药房划价 3药房退药 4医技划价 5体检开单 6收费划价 7门诊退费
     */
    public enum Djly{
        YSKD(1,"医生开单"),
        YFHJ(2,"药房划价"),
        YFTY(3,"药房退药"),
        YJHJ(4,"医技划价"),
        TJKD(5,"体检开单"),
        SFHJ(6,"收费划价"),
        MZTF(7,"门诊退费"),
        ;

        private int code;

        private String msg;

        Djly(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 附加类别  2 处方皮试项目 3处方代煎费
     */
    public enum Fjlb{
        CFPSXM(2,"处方皮试项目"),
        CFDJF(3,"处方代煎费"),
        ;

        private int code;

        private String msg;

        Fjlb(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 处方类型 1 西药 2中成药 3中草药
     */
    public enum OpCflx{
        XY(1,"西药"),
        ZCY(2,"中成药"),
        CY(3,"中草药"),
        ;

        private int code;

        private String msg;

        OpCflx(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 系统参数
     */
    public enum Xtcs{
        MZJYF("MZJYF","门诊煎药费对应的收费项目（每贴费用）"),
        MZDZCFZDXEXY("MZDZCFZDXEXY","门诊单张处方最大限额(西药/中成药)"),
        MZDZCFZDXECY("MZDZCFZDXECY","门诊单张处方最大限额(草药)"),
        CFDYMJY("CFDYMJY","麻、精一处方判定条件，如果有多种类型  用“,”隔开"),
        CFDYJE("CFDYJE","精二处方判定条件，如果有多种类型  用“,”隔开"),
        ;

        private String code;

        private String msg;

        Xtcs(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     *标准数据字典（暂未使用）
     */
    public enum DicGbsj02{
        XY(166,"西药"),
        ;

        private int code;

        private String msg;

        DicGbsj02(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 作废判别 1是 0否
     */
    public enum Zfpb{
        YES(1,"是"),
        NO(0,"否"),
        ;

        private int code;

        private String msg;

        Zfpb(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 执行判别 1已执行 0未执行
     */
    public enum Zxpb{
        YZX(1,"已执行"),
        WZX(0,"未执行"),
        ;

        private int code;

        private String msg;

        Zxpb(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 处方标志 1是 0否
     */
    public enum Cfbz{
        YES(1,"是"),
        NO(0,"否"),
        ;

        private int code;

        private String msg;

        Cfbz(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志
     */
    public enum Ztbz{
        YES(1,"组套标志"),
        NO(0,"非组套标志"),
        ;

        private int code;

        private String msg;

        Ztbz(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 执行状态 0：未执行  1：部分执行   5：全部执行
     */
    public enum Zxzt{
        WZX("0","未执行"),
        BFZX("1","部分执行"),
        QBZX("5","全部执行"),
        ;

        private String code;

        private String msg;

        Zxzt(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
