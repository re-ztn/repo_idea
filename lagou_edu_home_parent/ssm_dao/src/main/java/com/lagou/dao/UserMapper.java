package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

public interface UserMapper {

    public List<User> findAllUserByPage(UserVO userVO);

    public void updateUserStatus(User user);

    public User login(User user);


    /*
        根据用户id清空中奖表
     */
    public void deleteUserContextRole(Integer userId);

    /*
        分配角色
     */
    public void userContextRole(User_Role_relation user_role_relation);

    /*
       根据用户id查询关联信息
    */
    public List<Role> findUserRelationRoleById(Integer id);


    /*
        2.根据角色id,查询角色所拥有的顶级菜单（-1）
     */
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);

    /*
         3.根据pid,查询子菜单信息
     */
    public List<Menu> findSubMenuByPid(Integer pid);

    /*
        4.获取用户所拥有的资源权限信息
     */
    public List<Resource> findResourceByRoleId(List<Integer> ids);
}
