ALTER TABLE op_ghks
ADD COLUMN `PEDIATRICS` varchar(1) NULL DEFAULT 0 COMMENT '是否儿科科室 1：是 0：否' AFTER `INTERNET`;
