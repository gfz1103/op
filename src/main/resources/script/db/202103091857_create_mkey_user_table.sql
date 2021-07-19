CREATE TABLE `mkey_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `sys_user_id` int NOT NULL COMMENT '用户ID',
  `mkey_user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'mkey用户标识',
  `ca_zsxlh` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'CA证书序列号',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `status` tinyint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'CA用户表' ROW_FORMAT = DYNAMIC;
