package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVO userVO) {
        PageInfo<User> allUserByPage = userService.findAllUserByPage(userVO);

        return new ResponseResult(true, 200, "查询成功", allUserByPage);
    }

    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(Integer id, String status) {
        userService.updateUserStatus(id, status);

        return new ResponseResult(true, 200, "更新用户状态成功", null);
    }

    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User login = userService.login(user);
        if (login != null) {
            //保存用户id和access_token到session中
            HttpSession session = request.getSession();
            String access_token = UUID.randomUUID().toString();
            session.setAttribute("access_token", access_token);
            session.setAttribute("user_id", login.getId());
            HashMap<String, Object> map = new HashMap<>();
            map.put("access_token", access_token);
            map.put("user_id", login.getId());
            map.put("user", login);
            return new ResponseResult(true, 1, "登入成功", map);
        }

        return new ResponseResult(true, 400, "用户名或密码错误", null);
    }

    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRelationRoleById(Integer id) {

        List<Role> roleList = userService.findUserRelationRoleById(id);

        return new ResponseResult(true, 200, "分配角色回显成功", roleList);
    }

    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVO userVO) {
        userService.userContextRole(userVO);

        ResponseResult responseResult = new ResponseResult(true, 200, "分配角色成功", null);
        return responseResult;
    }

    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request) {

        //1.获取请求头中的token
        String header_token = request.getHeader("Authorization");

        //2.获取session中的token
        String access_token = (String) request.getSession().getAttribute("access_token");

        //3.判断token是否一致
        if (!header_token.equals(access_token)) {
            Integer user_id = (Integer) request.getSession().getAttribute("user_id");

            return userService.getUserPermissions(user_id);
        }

        return new ResponseResult(false, 400, "获取菜单信息失败", null);
    }
}
