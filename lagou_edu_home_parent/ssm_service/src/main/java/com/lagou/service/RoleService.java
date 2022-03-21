package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVO;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface RoleService {
    /**
     * 查询所有角色&条件查询
     */
    public List<Role> findAllRole(Role role);

    /*
    根据角色ID查询菜单信息
    */
    List<String> findMenuByRoleId(Integer roleId);
    /*
        为角色分配菜单
     */
    public void roleContextMenu(RoleMenuVO roleMenuVO);

    /*
        删除角色
    */
    public void deleteRole(Integer roleId);
}
