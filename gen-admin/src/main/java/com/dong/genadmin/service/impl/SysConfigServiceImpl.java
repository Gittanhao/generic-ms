package com.dong.genadmin.service.impl;

import com.dong.genadmin.generator.mapper.SysConfigMapper;
import com.dong.genadmin.generator.model.SysConfig;
import com.dong.genadmin.manual.mapper.MSysConfigMapper;
import com.dong.genadmin.service.SysConfigService;
import com.dong.gencore.page.MybatisPageHelper;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysConfigServiceImpl
 * @Description TODO
 * @Date 2019/10/3 10:51
 * @Created by dong
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {
    @Resource
    private SysConfigMapper sysConfigMapper;
    @Resource
    private MSysConfigMapper mSysConfigMapper;

    @Override
    public List<SysConfig> findByLabel(String label) {
        return mSysConfigMapper.findByLabel(label);
    }

    @Override
    public int save(SysConfig record) {
        return sysConfigMapper.insert(record);
    }

    @Override
    public int delete(SysConfig record) {
        return sysConfigMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysConfig> records) {
        return 0;
    }

    @Override
    public SysConfig findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, mSysConfigMapper);
    }
}
