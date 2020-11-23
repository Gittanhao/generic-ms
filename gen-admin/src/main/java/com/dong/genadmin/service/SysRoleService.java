package com.dong.genadmin.service;

import com.dong.genadmin.generator.model.SysMenu;
import com.dong.genadmin.generator.model.SysRole;
import com.dong.genadmin.generator.model.SysRoleMenu;
import com.dong.gencore.service.CurdService;

import java.util.List;

/**
 * @Classname SysRoleService
 * @Description TODO
 * @Date 2019/10/2 10:49
 * @Created by dong
 */
public interface SysRoleService extends CurdService<SysRole> {
    /**
     * 查询所有
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询角色菜单
     * @param roleId
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);
}
