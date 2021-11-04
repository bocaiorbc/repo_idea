package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.Role_menu_relation;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
   private RoleMapper roleMapper;

    /*
    查询所有角色(条件查询)
     */
    @Override
    public List<Role> findAllRole(Role role) {

        List<Role> list = roleMapper.findAllRole(role);

        return list;
    }

    /*
    添加角色
     */
    @Override
    public void saveRole(Role role) {

        //1.补全信息
        Date date = new Date();
        role.setCreatedTime(date);
        role.setUpdatedTime(date);
        role.setUpdatedBy("123");
        role.setCreatedBy("123");
        //2.调用mapper方法
        roleMapper.saveRole(role);
    }

    /*
    修改角色
     */
    @Override
    public void updateRole(Role role) {
        //1.补全信息
        role.setUpdatedTime(new Date());

        //2.调用mapper方法
        roleMapper.updateRole(role);
    }

    /*
        根据角色id查询该角色关联的菜单信息id
     */
    @Override
    public List<Integer> findMenuByRoleId(Integer roleid) {
        List<Integer> list = roleMapper.findMenuByRoleId(roleid);

        return list;
    }

    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {

        //1.清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        //2.为角色分配菜单

        for (Integer mid : roleMenuVo.getMenuIdList()) {

            Role_menu_relation relation = new Role_menu_relation();
            relation.setMenuId(mid);
            relation.setRoleId(roleMenuVo.getRoleId());

            //封装数据
            Date date = new Date();
            relation.setCreatedTime(date);
            relation.setUpdatedTime(date);
            relation.setCreatedBy("system");
            relation.setUpdatedby("system");

            roleMapper.roleContextMenu(relation);
        }


    }

    @Override
    public void deleteRole(Integer roleid) {

        //调用根据roleid清空中间表
        roleMapper.deleteRoleContextMenu(roleid);

        roleMapper.deleteRole(roleid);
    }
}
