package com.lagou.service.impl;

import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findSubMenuListByPid(int pid) {

        List<Menu> menuList = menuMapper.findSubMenuListByPid(pid);

        return menuList;
    }

    @Override
    public List<Menu> findAllMenu() {
        List<Menu> list = menuMapper.findAllMenu();
        return list;
    }

    @Override
    public Menu findMenuById(Integer id) {


        return menuMapper.findMenuById(id);
    }

    @Override
    public void saveMenu(Menu menu) {

        //补全信息
        menu.setParentId(1);
        menu.setLevel(1);
        menu.setCreatedBy("system");
        menu.setUpdatedBy("system");
        Date date = new Date();
        menu.setCreatedTime(date);
        menu.setUpdatedTime(date);

        menuMapper.saveMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {

        //补全信息
        menu.setParentId(1);
        menu.setLevel(1);
        menu.setCreatedBy("system");
        menu.setUpdatedBy("system");
        Date date = new Date();
        menu.setCreatedTime(date);
        menu.setUpdatedTime(date);

        menuMapper.updateMenu(menu);
    }
}
