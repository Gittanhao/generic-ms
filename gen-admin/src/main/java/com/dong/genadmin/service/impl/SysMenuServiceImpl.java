package com.dong.genadmin.service.impl;

import com.dong.genadmin.constant.SysConstants;
import com.dong.genadmin.generator.mapper.SysMenuMapper;
import com.dong.genadmin.generator.model.SysMenu;
import com.dong.genadmin.manual.mapper.MSysMenuMapper;
import com.dong.genadmin.manual.model.MSysMenu;
import com.dong.genadmin.service.SysMenuService;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SysMenuServiceImpl
 * @Description TODO
 * @Date 2019/10/2 17:04
 * @Created by dong
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Resource
    private MSysMenuMapper mSysMenuMapper;

    @Override
    public List<MSysMenu> findTree(String userName, int menuType) {
        List<MSysMenu> sysMenus = new ArrayList<>();
        List<MSysMenu> menus = findByUserName(userName);
        for (MSysMenu menu : menus) {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);
                if(!exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        }
        sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus, menus, menuType);
        return sysMenus;
    }

    private boolean exists(List<MSysMenu> sysMenus, MSysMenu mSysMenu) {
        boolean exist = false;
        for(MSysMenu menu:sysMenus) {
            if(menu.getId().equals(mSysMenu.getId())) {
                exist = true;
            }
        }
        return exist;
    }

    private void findChildren(List<MSysMenu> sysMenus, List<MSysMenu> menus, int menuType) {
        for (MSysMenu SysMenu : sysMenus) {
            List<MSysMenu> children = new ArrayList<>();
            for (MSysMenu menu : menus) {
                if(menuType == 1 && menu.getType() == 2) {
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue ;
                }
                if (SysMenu.getId() != null && SysMenu.getId().equals(menu.getParentId())) {
                    menu.setParentName(SysMenu.getName());
                    menu.setLevel(SysMenu.getLevel() + 1);
                    if(!exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            SysMenu.setChildren(children);
            children.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children, menus, menuType);
        }
    }

    @Override
    public List<MSysMenu> findByUserName(String userName) {
        if (null == userName || "".equals(userName) || SysConstants.ADMIN.equalsIgnoreCase(userName)) {
            return mSysMenuMapper.findAll();
        }
        return mSysMenuMapper.findByUserName(userName);
    }

    @Override
    public int save(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    @Override
    public int delete(SysMenu record) {
        return sysMenuMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysMenu> records) {
        return 0;
    }

    @Override
    public SysMenu findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }
}
