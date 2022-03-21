package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询所有角色&条件查询
     */
    public List<Role> findAllRole(Role role);

    /*
        根据角色ID查询菜单信息
    */
    public List<String> findMenuByRoleId(Integer roleId);

    /*
        根据roleId清空关联表
     */
    public void deleteRoleContextMenu(Integer rId);

    /*
        为角色分配菜单信息·
     */
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    /*
        删除角色
     */
    public void deleteRole(Integer roleId);
}
