-- 岗位表添加部门字段
-- 修改时间：2026-03-30
-- 说明：为岗位表添加部门关联功能

-- 添加部门ID字段
ALTER TABLE `sys_post` ADD COLUMN `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID' AFTER `status`;

-- 添加索引以提升查询性能
ALTER TABLE `sys_post` ADD INDEX `idx_dept_id` (`dept_id`);

-- 更新现有数据的部门ID（可选，根据实际情况调整）
-- 如果不需要为现有数据设置部门，可以注释掉以下语句
-- UPDATE `sys_post` SET `dept_id` = 103 WHERE `post_id` = 1;  -- 高级工程师归属到某部门
-- UPDATE `sys_post` SET `dept_id` = 103 WHERE `post_id` = 2;  -- 运营专员归属到某部门
