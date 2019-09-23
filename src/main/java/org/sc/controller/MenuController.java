package org.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {

    private static final Short MENU = 1;

    private static final Short BUTTON = 2;

    private static final Short BUTTON_MENU = 3;

    private static final Short LEVEL_ONE = 1;
    private static final Short LEVEL_TWO = 2;
    private static final Short LEVEL_THREE = 3;


    @RequestMapping("/get_menu")
    public MenuPermissionVO menuData(){

        // 一级的子菜单
        List<MenuPermissionVO> child = new ArrayList<>();
        // 二级的子菜单
        List<MenuPermissionVO> child1 = new ArrayList<>();

        // 三级按钮
        MenuPermissionVO menuPermissionVO2 = new MenuPermissionVO();
        menuPermissionVO2.setId(5);
        menuPermissionVO2.setSuperId(3);
        menuPermissionVO2.setName("详情");
        menuPermissionVO2.setUrl("v1/service/detail");
        menuPermissionVO2.setType(BUTTON);
        menuPermissionVO2.setLevel(LEVEL_THREE);
        menuPermissionVO2.setOrder(1);
        child1.add(menuPermissionVO2);

        MenuPermissionVO menuPermissionVO3 = new MenuPermissionVO();
        menuPermissionVO3.setId(6);
        menuPermissionVO3.setSuperId(3);
        menuPermissionVO3.setName("导出");
        menuPermissionVO3.setUrl("v1/service/export");
        menuPermissionVO3.setType(BUTTON_MENU);
        menuPermissionVO3.setLevel(LEVEL_THREE);
        menuPermissionVO3.setOrder(1);
        child1.add(menuPermissionVO3);

        // 二级菜单
        MenuPermissionVO menuPermissionVO1 = new MenuPermissionVO();
        menuPermissionVO1.setId(3);
        menuPermissionVO1.setSuperId(1);
        menuPermissionVO1.setName("客服工作台");
        menuPermissionVO1.setUrl("www.h5.url");
        menuPermissionVO1.setType(MENU);
        menuPermissionVO1.setLevel(LEVEL_TWO);
        menuPermissionVO1.setOrder(1);
        menuPermissionVO1.setChildPermission(child1);
        child.add(menuPermissionVO1);

        // 一级菜单
        MenuPermissionVO menuPermissionVO = new MenuPermissionVO();
        menuPermissionVO.setId(1);
        menuPermissionVO.setSuperId(0);
        menuPermissionVO.setName("客服管理");
        menuPermissionVO.setUrl("www.h5.url");
        menuPermissionVO.setType(MENU);
        menuPermissionVO.setLevel(LEVEL_ONE);
        menuPermissionVO.setOrder(1);
        menuPermissionVO.setChildPermission(child);

        return menuPermissionVO;
    }
}
