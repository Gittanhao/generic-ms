package com.dong.genadmin.service.impl;

import com.dong.genadmin.generator.mapper.SysLoginLogMapper;
import com.dong.genadmin.generator.model.SysLoginLog;
import com.dong.genadmin.manual.mapper.MSysLoginLogMapper;
import com.dong.genadmin.service.SysLoginLogService;
import com.dong.gencore.page.MybatisPageHelper;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysLoginLogServiceImpl
 * @Description TODO
 * @Date 2019/10/3 11:21
 * @Created by dong
 */
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {
    @Resource
    private SysLoginLogMapper sysLoginLogMapper;
    @Resource
    private MSysLoginLogMapper mSysLoginLogMapper;

    @Override
    public int save(SysLoginLog record) {
        return 0;
    }

    @Override
    public int delete(SysLoginLog record) {
        return sysLoginLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLoginLog> records) {
        return 0;
    }

    @Override
    public SysLoginLog findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, mSysLoginLogMapper);
    }
}
