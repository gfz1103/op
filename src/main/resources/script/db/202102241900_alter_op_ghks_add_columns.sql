ALTER TABLE `op_ghks`
ADD COLUMN `INTERNET` varchar(1) default '0' NOT NULL COMMENT '是否互联网医院科室，1：是 0：否';
