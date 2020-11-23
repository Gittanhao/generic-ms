package com.dong.genadmin.service.impl;

import com.dong.genadmin.constant.SysConstants;
import com.dong.genadmin.generator.mapper.SysRoleMapper;
import com.dong.genadmin.generator.mapper.SysRoleMenuMapper;
import com.dong.genadmin.generator.model.SysMenu;
import com.dong.genadmin.generator.model.SysRole;
import com.dong.genadmin.generator.model.SysRoleMenu;
import com.dong.genadmin.manual.mapper.MSysMenuMapper;
import com.dong.genadmin.manual.mapper.MSysRoleMapper;
import com.dong.genadmin.service.SysRoleService;
import com.dong.gencore.page.MybatisPageHelper;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.page.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysRoleServiceImpl
 * @Description TODO
 * @Date 2019/10/2 11:25
 * @Created by dong
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private MSysRoleMapper mSysRoleMapper;
    @Resource
    private MSysMenuMapper mSysMenuMapper;
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysRole> findAll() {
        return mSysRoleMapper.findAll();
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        // 如果是超级管理员
        if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
            mSysMenuMapper.findAll();
        }
        return mSysMenuMapper.findRoleMenus(roleId);
    }

    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if (records == null || records.size() == 0) {
            return 1;
        }
        for (SysRoleMenu record : records) {
            sysRoleMenuMapper.insert(record);
        }
        return 1;
    }

    @Override
    public int save(SysRole record) {
        return sysRoleMapper.insert(record);
    }

    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysRole> records) {
        return 0;
    }

    @Override
    public SysRole findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(@RequestBody PageRequest pageRequest) {
        Object name = pageRequest.getParam("name");
        if (name != null) {
            return MybatisPageHelper.findPage(pageRequest, mSysRoleMapper, "findPageByName", name);
        }
        return MybatisPageHelper.findPage(pageRequest, mSysRoleMapper);
    }
}
