package com.dong.genadmin.service.impl;

import com.dong.genadmin.generator.mapper.SysDictMapper;
import com.dong.genadmin.generator.model.SysDict;
import com.dong.genadmin.manual.mapper.MSysDictMapper;
import com.dong.genadmin.service.SysDictService;
import com.dong.gencore.page.MybatisPageHelper;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysDictServiceImpl
 * @Description TODO 字典管理业务层
 * @Date 2019/9/29 10:11
 * @Created by dong
 */
@Service
public class SysDictServiceImpl implements SysDictService {
    @Resource
    private SysDictMapper sysDictMapper;
    @Resource
    private MSysDictMapper mSysDictMapper;

    @Override
    public int save(SysDict record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDictMapper.insertSelective(record);
        }
        return sysDictMapper.insert(record);
    }

    @Override
    public int delete(SysDict record) {
        // 其他数据验证操作...
        // ...
        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        for (SysDict record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, mSysDictMapper);
    }

    @Override
    public List<SysDict> findByLabel(String label) {
        return mSysDictMapper.findByLabel(label);
    }
}
