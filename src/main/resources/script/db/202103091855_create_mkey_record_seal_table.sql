CREATE TABLE `mkey_record_seal`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `record_id` int NOT NULL COMMENT '签名记录ID',
  `user_id` int NOT NULL COMMENT '用户id',
  `seal` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'BASE64签章',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '数据签名' ROW_FORMAT = DYNAMIC;
