ALTER TABLE mp_easemob_user
ADD COLUMN `STATE` tinyint NULL COMMENT '-1删除 0禁用 1可用' AFTER `USERID`;
