package com.dong.genadmin.manual.mapper;

import com.dong.genadmin.generator.model.SysMenu;
import com.dong.genadmin.generator.model.SysRole;
import com.dong.genadmin.generator.model.SysUser;

import java.util.List;

/**
 * @Classname MSysUserMapper
 * @Description TODO
 * @Date 2019/9/30 14:28
 * @Created by dong
 */
public interface MSysUserMapper {

    /**
     * 分页
     * @return
     */
    List<SysUser> findPage();

    /**
     * 根据名称查询用户
     * @param name 用户名
     * @return
     */
    List<SysUser> findByName(String name);

    /**
     * 根据用户名查询用户权限
     * @param name 用户名
     * @return
     */
    List<SysMenu> findPermissions(String name);

    /**
     * 查询用户角色
     * @param userId 用户id
     * @return
     */
    List<SysRole> findUserRoles(Long userId);
}
