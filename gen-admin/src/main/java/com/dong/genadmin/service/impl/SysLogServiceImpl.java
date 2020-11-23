package com.dong.genadmin.service.impl;

import com.dong.genadmin.generator.mapper.SysLogMapper;
import com.dong.genadmin.generator.model.SysLog;
import com.dong.genadmin.manual.mapper.MSysLogMapper;
import com.dong.genadmin.service.SysLogService;
import com.dong.gencore.page.MybatisPageHelper;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysLogServiceImpl
 * @Description TODO
 * @Date 2019/10/3 11:37
 * @Created by dong
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;
    @Resource
    private MSysLogMapper mSysLogMapper;

    @Override
    public int save(SysLog record) {
        return 0;
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        return 0;
    }

    @Override
    public SysLog findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, mSysLogMapper);
    }
}
