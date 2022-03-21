package com.lagou.controller;

import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu() {
        List<Menu> allMenu = menuService.findAllMenu();
        ResponseResult responseResult = new ResponseResult(true, 200, "查询所有菜单信息成功", allMenu);
        return responseResult;
    }

    /*
        回显菜单信息
     */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id) {

        ResponseResult responseResult = null;
        List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("parentMenuList", subMenuListByPid);
        if (id == -1) {
            map.put("menuInfo", null);
            responseResult = new ResponseResult(true, 200, "添加回显成功", map);

        } else {
            Menu menuById = menuService.findMenuById(id);
            map.put("menuInfo", menuById);
            responseResult = new ResponseResult(true, 200, "修改回显成功", map);
        }

        return responseResult;
    }

}
