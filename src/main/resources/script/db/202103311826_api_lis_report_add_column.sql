ALTER TABLE `api_lis_report`
ADD COLUMN `BARCODE` varchar(500) NULL COMMENT '条码号';
ALTER TABLE `api_lis_report`
ADD COLUMN `JZKH` varchar(500) NULL COMMENT '就诊卡号或者住院号';
ALTER TABLE `api_lis_report`
ADD COLUMN `SAMPLINGDATE` datetime NULL COMMENT '采集日期';
ALTER TABLE `api_lis_report`
ADD COLUMN `RECEIPTDATE` datetime NULL COMMENT '采集医院接收日期';
ALTER TABLE `api_lis_report`
ADD COLUMN `RECEIPTDATE1` datetime NULL COMMENT '执行医院接收日期';
ALTER TABLE `api_lis_report`
ADD COLUMN `TESTDATE` datetime NULL COMMENT '校验时间';
ALTER TABLE `api_lis_report`
ADD COLUMN `TESTDOCTOR` varchar(20) NULL COMMENT '校验人姓名';
ALTER TABLE `api_lis_report`
ADD COLUMN `REPORTTYPE` varchar(1) NULL COMMENT '报告类型(0，普通结果，1，微生物结果)';
ALTER TABLE `api_lis_report`
ADD COLUMN `GERMRESULT` varchar(500) NULL COMMENT '细菌结果';
ALTER TABLE `api_lis_report`
ADD COLUMN `GERMRESULTTYPE` varchar(500) NULL COMMENT '细菌结果类型';
ALTER TABLE `api_lis_report`
ADD COLUMN `ANTIGERMCODE` varchar(500) NULL COMMENT '细菌项目ID';
ALTER TABLE `api_lis_report`
ADD COLUMN `ANTIGERMNAME` varchar(500) NULL COMMENT '细菌项目名称';
ALTER TABLE `api_lis_report`
ADD COLUMN `ANTICODE` varchar(500) NULL COMMENT '药敏项目id';
ALTER TABLE `api_lis_report`
ADD COLUMN `ANTINAME` varchar(500) NULL COMMENT '药敏项目名称';
ALTER TABLE `api_lis_report`
ADD COLUMN `ANTIRESULT` varchar(500) NULL COMMENT '药敏结果';
ALTER TABLE `api_lis_report`
ADD COLUMN `ANTIRESULT1` varchar(20) NULL COMMENT 'R耐药/S敏感/I中敏';
ALTER TABLE `api_lis_report`
ADD COLUMN `CANCEL` int(1) NULL COMMENT '撤销标记 1-撤销 0-正常';
