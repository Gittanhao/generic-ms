package com.dong.genadmin.service.impl;

import com.dong.genadmin.generator.mapper.SysMenuMapper;
import com.dong.genadmin.generator.mapper.SysUserMapper;
import com.dong.genadmin.generator.model.SysMenu;
import com.dong.genadmin.generator.model.SysRole;
import com.dong.genadmin.generator.model.SysUser;
import com.dong.genadmin.generator.model.SysUserRole;
import com.dong.genadmin.manual.mapper.MSysMenuMapper;
import com.dong.genadmin.manual.mapper.MSysUserMapper;
import com.dong.genadmin.manual.mapper.MSysUserRoleMapper;
import com.dong.genadmin.manual.model.MSysMenu;
import com.dong.genadmin.service.SysMenuService;
import com.dong.genadmin.service.SysUserService;
import com.dong.gencore.page.MybatisPageHelper;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname SysUserServiceImpl
 * @Description TODO
 * @Date 2019/9/30 14:22
 * @Created by dong
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private MSysUserMapper mSysUserMapper;
    @Resource
    private SysMenuService sysMenuService;  // 获取菜单中的权限
    @Resource
    private MSysUserRoleMapper mSysUserRoleMapper;  // 提供查询用户角色

    @Override
    public List<SysUser> findByName(String name) {
        return mSysUserMapper.findByName(name);
    }

    @Override
    public Set<String> findPermissions(String name) {
        Set<String> perms = new HashSet<>();
        List<MSysMenu> mSysMenus = sysMenuService.findByUserName(name);
        for (MSysMenu mSysMenu : mSysMenus) {
            if (mSysMenu.getPerms() != null && !"".equals(mSysMenu.getPerms())) {
                perms.add(mSysMenu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return mSysUserRoleMapper.findUserRoles(userId);
    }

    @Override
    public int save(SysUser record) {
        // 只处理了insert，暂未考虑update
        return sysUserMapper.insert(record);
    }

    @Override
    public int delete(SysUser record) {
        return sysUserMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysUser> records) {
        for (SysUser record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysUser findById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, mSysUserMapper);
    }
}
