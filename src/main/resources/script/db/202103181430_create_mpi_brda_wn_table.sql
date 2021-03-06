-- auto-generated definition
create table mpi_brda_wn
(
    BRID            bigint       not null comment '病人ID号 | 是一个内码，其它数据表与该表相联系的字段'
        primary key,
    MZHM            varchar(32)  not null comment '门诊号码 | 唯一一处记载病人门诊号码的地方，在程序中用于刷卡登记或查询相关记录使用',
    BRXM            varchar(40)  null comment '病人姓名',
    FYZH            varchar(20)  null comment '医疗证号',
    SFZH            varchar(20)  null comment '身份证号',
    BRXZ            bigint       null comment '病人性质 | 与patientProperties.xml字典关联',
    BRXB            int          null comment '病人性别 | GB/T 2261.1-2003 与gender.xml字典关联',
    CSNY            datetime     null comment '出生年月',
    HYZK            int          null comment '婚姻状况 | GB/T 2261.2-2003 与maritals.xml字典关联',
    ZYDM            varchar(20)  null comment '职业代码 | GB/T 6565-2009 与jobtitle.xml字典关联',
    MZDM            varchar(4)   null comment '民族代码 | GB3304-91 与ethnic.xml字典关联',
    XXDM            int          null comment '血型代码 | GA 324.6-2001 与blood.xml字典关联',
    GMYW            int          null comment '过敏药物',
    DWXH            bigint       null comment '单位序号',
    DWMC            varchar(40)  null comment '单位名称',
    DWDH            varchar(16)  null comment '单位电话',
    DWYB            varchar(6)   null comment '单位邮编',
    HKDZ            varchar(200) null comment '户口地址',
    JTDH            varchar(16)  null comment '家庭电话',
    HKYB            varchar(6)   null comment '户口邮编',
    JZCS            int          null comment '就诊次数',
    JZRQ            datetime     null comment '就诊日期',
    CZRQ            datetime     null comment '初诊日期',
    JZKH            varchar(40)  null comment '就诊卡号',
    SFDM            int          null comment '省份代码',
    JGDM            int          null comment '籍贯代码',
    GJDM            varchar(4)   null comment '国籍代码',
    LXRM            varchar(20)  null comment '联系人名',
    LXGX            int          null comment '联系关系',
    LXDZ            varchar(100) null comment '联系地址',
    LXDH            varchar(16)  null comment '联系电话',
    DBRM            varchar(10)  null comment '担保人名',
    DBGX            int          null comment '担保关系',
    SBHM            varchar(20)  null comment '社保号码',
    YBKH            varchar(20)  null comment '医保卡号',
    ZZTX            int          null comment '在职退休',
    JDJG            varchar(20)  not null comment '建档机构',
    JDSJ            datetime     null comment '建档时间',
    JDR             varchar(10)  null comment '建档人',
    ZXBZ            int          null comment '注销标志 | 0：正常 1：注销',
    ZXR             varchar(10)  null comment '注销人',
    ZXSJ            datetime     null comment '注销时间',
    XGSJ            datetime     null comment '修改时间',
    CSD_SQS         bigint       null comment '出生地_省区市',
    CSD_S           bigint       null comment '出生地_市',
    CSD_X           bigint       null comment '出生地_县',
    JGDM_SQS        bigint       null comment '籍贯代码_省区市',
    JGDM_S          bigint       null comment '籍贯代码_市',
    XZZ_SQS         bigint       null comment '现住址_省区市',
    XZZ_S           bigint       null comment '现住址_市',
    XZZ_X           bigint       null comment '现住址_县',
    XZZ_YB          varchar(20)  null comment '现住址_邮编',
    XZZ_DH          varchar(20)  null comment '现住址_电话',
    HKDZ_SQS        bigint       null comment '户口地址_省区市',
    HKDZ_S          bigint       null comment '户口地址_市',
    HKDZ_X          bigint       null comment '户口地址_县',
    XZZ_QTDZ        varchar(60)  null comment '现住址_其他地址',
    HKDZ_QTDZ       varchar(60)  null comment '户口地址_其他地址',
    SRC             varchar(10)  null comment '数据来源(标识导入数据)',
    CARDTYPE        int          null,
    GRBM            varchar(30)  null,
    GSBJ            int          null,
    JMBZ            varchar(10)  null comment '减免标志',
    PZLX            varchar(10)  null comment '减免凭证类型',
    PZHM            varchar(100) null comment '减免凭证号码',
    GSRDH           varchar(10)  null comment '工伤认定号',
    DBBZ            char         null comment '大病病种',
    SCBZ            char         null comment '上传标志',
    PHOTO           varchar(100) null comment '照片',
    ZJLX            varchar(2)   null comment '证件类型',
    BRDH            varchar(50)  null comment '本人电话',
    LXRDH           varchar(50)  null comment '联系人电话',
    ISNH            int          null comment '是否农合',
    HJBZ            varchar(2)   null comment '户籍标志',
    NATIONALITYCODE varchar(3)   null comment '国籍 | GB/T 2659-2000',
    BXCABXBXCARDNO  varchar(50)  null comment '保险卡号',
    BXSTART         datetime     null comment '保险有效期起',
    BXEND           datetime     null comment '保险有效期止',
    BXCOMPANY       varchar(50)  null comment '保险公司',
    XGR             varchar(10)  null comment '修改人',
    constraint UQ_MS_BRDA_GRBM
        unique (GRBM),
    constraint UQ_MS_BRDA_SFZH
        unique (SFZH, ZJLX)
)
    comment '卫宁_门诊_病人档案' charset = utf8mb4;

create index IDX_MS_BRDA_WN_JDJG
    on mpi_brda (JDJG);

create index IDX_MS_BRDA_WN_MZHM
    on mpi_brda (MZHM);

