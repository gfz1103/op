-- 修改 op_zydj 字段备注
ALTER TABLE op_zydj
MODIFY COLUMN SQZT varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '申请状态 | 1：新申请    2：已提交    3：已入院' AFTER KDRQ;
