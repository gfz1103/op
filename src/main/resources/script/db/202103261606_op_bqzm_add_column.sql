ALTER TABLE `op_bqzm`
ADD COLUMN `DJLX` varchar(1) NULL COMMENT '单据类型 1病情证明单 2疾病证明单' AFTER `LX`,
ADD COLUMN `JYLX` varchar(1) NULL COMMENT '建议类型 1免修体育课 2休假n天 3休学n学期 4其他' AFTER `JZLSH`,
ADD COLUMN `JYZ` varchar(255) NULL COMMENT '建议值 对于建议类型为2和3的为n的值，4为其他建议' AFTER `JYLX`;
