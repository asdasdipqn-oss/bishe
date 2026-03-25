package com.renli.common.utils;

import com.renli.common.core.domain.entity.SysUser;

/**
 * 部门权限工具类
 *
 * @author claude
 */
public class DeptPermissionUtils
{
    /**
     * 获取当前用户的部门权限类型
     *
     * @param currentUser 当前用户
     * @return 权限类型：ADMIN-管理员，DEPT_MGR-部门经理，DEPT_USER-部门普通员工
     */
    public static String getUserPermissionType(SysUser currentUser)
    {
        if (currentUser == null || currentUser.getRoles() == null || currentUser.getRoles().isEmpty()) {
            return "DEPT_USER";
        }

        for (com.renli.common.core.domain.entity.SysRole role : currentUser.getRoles()) {
            String roleKey = role.getRoleKey();
            // 管理员角色
            if ("admin".equals(roleKey) || "gly".equals(roleKey) || "hr".equals(roleKey)) {
                return "ADMIN";
            }
            // 部门经理角色
            if ("jl".equals(roleKey)) {
                return "DEPT_MGR";
            }
        }

        // 普通员工角色
        return "DEPT_USER";
    }

    /**
     * 判断是否是管理员
     *
     * @param currentUser 当前用户
     * @return true-管理员，false-非管理员
     */
    public static boolean isAdmin(SysUser currentUser)
    {
        return "ADMIN".equals(getUserPermissionType(currentUser));
    }

    /**
     * 判断是否是部门经理
     *
     * @param currentUser 当前用户
     * @return true-部门经理，false-非部门经理
     */
    public static boolean isDeptManager(SysUser currentUser)
    {
        return "DEPT_MGR".equals(getUserPermissionType(currentUser));
    }

    /**
     * 判断是否是部门普通员工
     *
     * @param currentUser 当前用户
     * @return true-部门普通员工，false-非部门普通员工
     */
    public static boolean isDeptUser(SysUser currentUser)
    {
        return "DEPT_USER".equals(getUserPermissionType(currentUser));
    }

    /**
     * 获取用户可见的部门名称
     * 管理员返回null（可看所有部门）
     * 部门经理和普通员工返回自己部门的名称
     *
     * @param currentUser 当前用户
     * @return 部门名称，管理员返回null
     */
    public static String getUserVisibleDeptName(SysUser currentUser)
    {
        if (isAdmin(currentUser)) {
            return null; // 管理员可以看所有部门
        }

        if (currentUser.getDept() != null && currentUser.getDept().getDeptName() != null) {
            return currentUser.getDept().getDeptName();
        }

        return null;
    }

    /**
     * 获取用户可见的部门ID
     * 管理员返回null（可看所有部门）
     * 部门经理和普通员工返回自己部门的ID
     *
     * @param currentUser 当前用户
     * @return 部门ID，管理员返回null
     */
    public static Long getUserVisibleDeptId(SysUser currentUser)
    {
        if (isAdmin(currentUser)) {
            return null; // 管理员可以看所有部门
        }

        if (currentUser.getDept() != null) {
            return currentUser.getDept().getDeptId();
        }

        return null;
    }
}
