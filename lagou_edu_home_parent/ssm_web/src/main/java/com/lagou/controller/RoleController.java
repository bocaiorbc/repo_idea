package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    /*
        查询所有角色(根据条件)
     */
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){

        List<Role> list = roleService.findAllRole(role);

        return new ResponseResult(true,200,"查询所有角色成功",list);

    }

    /*
        添加&修改角色
     */
    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role){
        if (role.getId() == null) {
            roleService.saveRole(role);
            return new ResponseResult(true, 200, "添加角色成功", null);
        }else {
            roleService.updateRole(role);
            return new ResponseResult(true, 200, "修改角色成功", null);
        }

    }

    /*
    查询所有父子菜单信息(分配菜单的第一个接口)
 */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){

        //-1 表示查询所有的父子级菜单
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);

        //响应数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);


        return new ResponseResult(true,200,"查询所有菜单信息成功",map);
    }

    /*
    根据角色id查询该角色关联的菜单信息id
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<Integer> list = roleService.findMenuByRoleId(roleId);

        return new ResponseResult(true,200,"根据角色id查询该角色关联的菜单信息id成功",list);
    }

    /*
        为角色分配菜单
     */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.roleContextMenu(roleMenuVo);
        return new ResponseResult(true,200,"为角色分配菜单成功",null);
    }

    /*
     删除角色
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){
        roleService.deleteRole(id);

        return new ResponseResult(true,200,"删除角色成功",null);
    }

}
