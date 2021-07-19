-- ----------------------------
-- Table structure for mp_easemob_user  环信用户表（客服使用）(mp_easemob_user)
-- ----------------------------
CREATE TABLE `mp_easemob_user` (
  `ID` bigint NOT NULL COMMENT '主键',
  `USERNAME` varchar(255) COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(255) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `NICKNAME` varchar(255) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '昵称',
  `UUID` varchar(50) COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'UUID',
  `ACTIVATED` varchar(8) COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账户状态 ',
  `CREATED` bigint NOT NULL COMMENT '创建时间',
  `MODIFIED` bigint NOT NULL COMMENT '修改时间',
  `TYPE` varchar(10) COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '环信用户类型',
  `USERTYPE` varchar(2) COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户类型 1用户 2医生(包含客服)',
  `USERID` bigint NOT NULL COMMENT '用户ID',
  `CREATE_USER_ID` bigint NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` bigint NOT NULL COMMENT '修改人',
  `UPDATE_TIME` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='环信用户表（客服使用）';
