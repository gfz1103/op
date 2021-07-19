-- ----------------------------
-- Table structure for mp_user_consult  用户咨询表（客服使用）(mp_user_consult)
-- ----------------------------
CREATE TABLE `mp_user_consult` (
  `ID` int NOT NULL COMMENT '主键',
  `USERID` int COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '咨询的客服ID',
  `ZXRID` bigint COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '咨询用户ID',
  `ZXRXM`  varchar(30) NULL COMMENT '咨询人姓名',
  `ZXRSJHM`  varchar(30) NULL COMMENT '咨询人手机号码',
  `ZXKSSJ` datetime  COMMENT '咨询开始时间',
  `ZXJSSJ` datetime  COMMENT '咨询结束时间',
  `ZXZT` int NOT NULL COMMENT '咨询状态（1开始咨询 2结束咨询）',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户咨询表（客服使用）';
