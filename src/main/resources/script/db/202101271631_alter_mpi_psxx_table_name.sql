ALTER TABLE `mpi_psxx` RENAME TO mp_psxx;

ALTER TABLE `mp_psxx`
ADD COLUMN `JZLSH` varchar(50) NOT NULL COMMENT '就诊流水号' AFTER `CFHM`;