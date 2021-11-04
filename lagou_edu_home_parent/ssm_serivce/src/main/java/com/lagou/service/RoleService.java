package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;

import java.util.List;

public interface RoleService {

    /*
        查询所有角色(条件)
     */
    public List<Role> findAllRole(Role role);

    /*
        添加角色
     */
    public void saveRole(Role role);

    /*
        修改角色
     */
    public void updateRole(Role role);

    /*
       根据角色id查询该角色关联的菜单信息id
    */
    public List<Integer> findMenuByRoleId(Integer roleid);

    /*
        为角色分配菜单信息
     */
    public void roleContextMenu(RoleMenuVo roleMenuVo);

    /*
        删除角色
     */
    public void deleteRole(Integer roleid);

}
