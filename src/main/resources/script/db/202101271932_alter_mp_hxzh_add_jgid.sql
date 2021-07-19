ALTER TABLE `mp_psxx`
    ADD COLUMN `PYYDH` varchar(20)  COMMENT '派件员电话' AFTER `PJY`;

ALTER TABLE `mp_psxx`
    ADD COLUMN `JGID` varchar(20)  not null COMMENT '机构ID' AFTER `ID`;

ALTER TABLE `mp_hxzh`
    ADD COLUMN `WZFS` varchar(1)  not null COMMENT '问诊方式' AFTER `JZLSH`;