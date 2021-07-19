-- ----------------------------
-- Table structure for mp_evaluate
-- ----------------------------
CREATE TABLE `mp_black_list`  (
  `ID` bigint auto_increment NOT NULL COMMENT '主键ID',
  `SFZH` varchar(18) NOT NULL COMMENT '身份证号码',
  `NAME` varchar(10) NOT NULL COMMENT '姓名',
  `REMAKE` varchar(500) NOT NULL COMMENT '备注',
  `STATE` int(1) NOT NULL COMMENT '数据有效性， 0-无效， 1-有效',
  `CJSJ` datetime NOT NULL COMMENT '创建时间',
  `XGSJ` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '黑名单表' ROW_FORMAT = DYNAMIC;
