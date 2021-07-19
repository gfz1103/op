CREATE TABLE `mkey_record_ts`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `record_id` int NOT NULL COMMENT 'mkey记录ID',
  `ts` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'BASE64时间戳',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '签名记录时间戳' ROW_FORMAT = DYNAMIC;
