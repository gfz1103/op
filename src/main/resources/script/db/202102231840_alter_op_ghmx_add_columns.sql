ALTER TABLE `op_ghmx`
ADD COLUMN `WZJE` decimal(10, 2)  NOT NULL COMMENT '互联网问诊金额' AFTER `CKJE`;

ALTER TABLE `op_mzxx`
ADD COLUMN `PSJE` decimal(10, 2)  NOT NULL COMMENT '配送金额';