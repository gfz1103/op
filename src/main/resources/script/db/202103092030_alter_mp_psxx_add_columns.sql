ALTER TABLE `mp_psxx`
    ADD COLUMN `KSSJ` datetime  COMMENT '配送开始时间' AFTER `YJDDSJ`;

ALTER TABLE `mp_psxx`
    ADD COLUMN `JSSJ` datetime  COMMENT '配送完成时间' AFTER `KSSJ`;
