ALTER TABLE `op_ghmx`
ADD COLUMN `SFMF` int NOT NULL default 0 COMMENT '是否免费 0-不免费 1-义诊 2-免费' AFTER `GHLX`;
