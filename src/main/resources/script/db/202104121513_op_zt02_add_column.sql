ALTER TABLE `op_zt02`
ADD COLUMN `JB` varchar(10) NULL COMMENT '几倍 （西药用于计算单次用量（YCJL），草药计算药品数量（YPSL）=>【此时一般相等】）' AFTER `XMSL`;
