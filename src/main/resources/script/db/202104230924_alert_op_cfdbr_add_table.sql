CREATE TABLE `op_cfdbr`  (
  `DBID` int NOT NULL COMMENT '主键 代办ID',
  `CFSB` int NOT NULL COMMENT '关联op_cf01表主键',
  `JGID` int NOT NULL COMMENT '机构ID',
  `DBRXM` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '代办人姓名',
  `DBRLXDH` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '代办人联系电话',
  `SFZM` int NULL COMMENT '身份证明 对应证件类型',
  `BH` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '编号 ',
  PRIMARY KEY (`DBID`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '处方代办信息表' ROW_FORMAT = DYNAMIC;
