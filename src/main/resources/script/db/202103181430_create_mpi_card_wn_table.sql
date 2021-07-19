-- auto-generated definition
create table mpi_card_wn
(
    CARDID         char(16)    not null comment '编号'
        primary key,
    CARDTYPECODE   varchar(2)  null comment '卡类型 | 01=健康卡
02=市民卡
03=医保卡
09=其他卡',
    CARDNO         varchar(50) null comment '卡号',
    CREATEUNIT     varchar(16) null comment '创建机构',
    CREATEUSER     varchar(20) null comment '创建人',
    STATUS         char        null comment '状态 | 0=正常
1=挂失
2=注销3=失效',
    CREATETIME     datetime    null comment '创建时间',
    VALIDTIME      datetime    null comment '有效期',
    LASTMODIFYTIME datetime    null comment '最后修改时间',
    LASTMODIFYUNIT varchar(16) null comment '最后修改机构',
    LASTMODIFYUSER varchar(20) null comment '最后修改人',
    SCBZ           char        null,
    BRID           int         null comment '病人ID',
    BRXZ           int         null comment '病人性质',
    REGIONCODE     varchar(20) null,
    constraint CARD_INDX_TYPE_ID
        unique (CARDTYPECODE, CARDID),
    constraint CARD_INDX_TYPE_NO
        unique (CARDTYPECODE, CARDNO, STATUS)
)
    comment '卫宁_EMPI个人基本信息(卡)' charset = utf8mb4;

create index CARD_WN_INDX_EMPI_STATUS
    on mpi_card (STATUS, EMPIID);

create index MPI_CARD_WN_BRID
    on mpi_card (BRID);

