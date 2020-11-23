package com.dong.genadmin.service;

import com.dong.genadmin.generator.model.SysMenu;
import com.dong.genadmin.manual.model.MSysMenu;
import com.dong.gencore.service.CurdService;

import java.util.List;

/**
 * @Classname SysMenuService
 * @Description TODO 菜单管理
 * @Date 2019/10/2 15:41
 * @Created by dong
 */
public interface SysMenuService extends CurdService<SysMenu> {
    /**
     * 查询菜单树
     * @param userName 用户名
     * @param menuType 菜单类型：0，获取所有菜单，包含按钮；1，获取所有菜单，不包含按钮
     * @return
     */
    List<MSysMenu> findTree(String userName, int menuType);

    /**
     * 根据用户名查找菜单列表
     * @param userName
     * @return
     */
    List<MSysMenu> findByUserName(String userName);
}
