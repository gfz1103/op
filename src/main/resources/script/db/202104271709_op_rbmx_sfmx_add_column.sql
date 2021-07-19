ALTER TABLE `op_rbmx_sfmx`
ADD COLUMN `ZFB` decimal(12,2)  NOT NULL COMMENT '支付宝' AFTER `POS`;
ALTER TABLE `op_rbmx_sfmx`
ADD COLUMN `WX` decimal(12,2)  NOT NULL COMMENT '微信' AFTER `ZFB`;
ALTER TABLE `op_rbmx_sfmx`
ADD COLUMN `CZK` decimal(12,2)  NOT NULL COMMENT '充值卡' AFTER `WX`;

