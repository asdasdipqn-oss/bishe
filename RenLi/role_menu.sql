-- 给角色分配考勤管理菜单
-- 超级管理员(role_id=1)、管理员(role_id=8)
INSERT INTO `sys_role_menu` VALUES (1,1534),(1,1535),(1,1536);

-- 普通员工(role_id=5)、部门经理(role_id=6)、HR管理员(role_id=7)、用户(role_id=9)
INSERT INTO `sys_role_menu` VALUES (5,1534),(5,1535),(5,1536);
INSERT INTO `sys_role_menu` VALUES (6,1534),(6,1535),(6,1536);
INSERT INTO `sys_role_menu` VALUES (7,1534),(7,1535),(7,1536);
INSERT INTO `sys_role_menu` VALUES (8,1534),(8,1535),(8,1536);
INSERT INTO `sys_role_menu` VALUES (9,1534),(9,1535),(9,1536);
