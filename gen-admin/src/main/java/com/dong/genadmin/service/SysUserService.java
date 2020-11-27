package com.dong.genadmin.service;

import com.dong.genadmin.generator.model.SysUser;
import com.dong.genadmin.generator.model.SysUserRole;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.service.CurdService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * @Classname SysUserService
 * @Description TODO
 * @Date 2019/9/30 14:02
 * @Created by dong
 */
public interface SysUserService extends CurdService<SysUser> {
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
    Set<String> findPermissions(String name);

    /**
     * 查询用户角色
     * @param userId 用户id
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 查询所有用户
     * @param name
     * @return
     */
    List<SysUser> findAllUsers();

    /**
     * 导出所有用户
     */
    void exportUsers(HttpServletResponse response, PageRequest pageRequest);
}
