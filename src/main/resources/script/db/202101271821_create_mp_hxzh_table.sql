CREATE TABLE `mp_hxzh` (
     `jzlsh` varchar(50) not null COMMENT '就诊流水号',
     `userid` BIGINT not null  COMMENT '环信用户ID',
     `easemob` varchar(50) not null  COMMENT '环信用户账号',
     PRIMARY KEY (`jzlsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='环信账号信息';

ALTER TABLE mp_psxx
MODIFY COLUMN ID int NOT NULL AUTO_INCREMENT COMMENT '主键ID' FIRST ;