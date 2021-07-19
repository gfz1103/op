CREATE TABLE `mp_glks` (
     `ghks` int not null COMMENT '互联网挂号科室',
     `glks` int not null  COMMENT 'his挂号科室',
     PRIMARY KEY (`ghks`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='互联网科室HIS挂号科室关联表';
