ALTER TABLE `api_lis_report`
ADD COLUMN `JGID` varchar(20) NULL COMMENT '机构' AFTER `CANCEL`,
ADD COLUMN `BGDLBBM` varchar(10) NULL COMMENT '报告单类别编码' AFTER `JGID`,
ADD COLUMN `BGDLB` varchar(100) NULL COMMENT '报告单类别名称' AFTER `BGDLBBM`;


