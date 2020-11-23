package com.dong.genadmin.manual.mapper;

import com.dong.genadmin.generator.model.SysMenu;
import com.dong.genadmin.manual.model.MSysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname MSysMenuMapper
 * @Description TODO
 * @Date 2019/10/2 12:32
 * @Created by dong
 */
public interface MSysMenuMapper {
    /**
     * 查询角色菜单
     * @param roleId
     * @return
     */
    List<SysMenu> findRoleMenus(@Param(value = "roleId") Long roleId);

    List<MSysMenu> findAll();

    // 上面是角色管理中添加的mapper

    /**
     * 通过用户名查询
     * @param userName
     * @return
     */
    List<MSysMenu> findByUserName(@Param(value = "userName") String userName);  // 待修复的bug

}
