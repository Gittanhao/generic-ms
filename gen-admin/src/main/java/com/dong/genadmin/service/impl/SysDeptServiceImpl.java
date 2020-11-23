package com.dong.genadmin.service.impl;

import com.dong.genadmin.generator.mapper.SysDeptMapper;
import com.dong.genadmin.generator.model.SysDept;
import com.dong.genadmin.manual.mapper.MSysDeptMapper;
import com.dong.genadmin.manual.model.MSysDept;
import com.dong.genadmin.service.SysDeptService;
import com.dong.gencore.page.MybatisPageHelper;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SysDeptServiceImpl
 * @Description TODO
 * @Date 2019/9/30 16:09
 * @Created by dong
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {
    @Resource
    private SysDeptMapper sysDeptMapper;
    @Resource
    private MSysDeptMapper mSysDeptMapper;

    @Override
    public int save(SysDept record) {
        return sysDeptMapper.insert(record);
    }

    @Override
    public int delete(SysDept record) {
        return sysDeptMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDept> records) {
        for (SysDept record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDept findById(Long id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, mSysDeptMapper);
    }

    @Override
    public List<MSysDept> findTree() {
        List<MSysDept> sysDepts = new ArrayList<>();
        List<MSysDept> depts = mSysDeptMapper.findAll();
        for (MSysDept dept : depts) {
            if (dept.getParentId() == null || dept.getParentId() == 0) {
                dept.setLevel(0);
                sysDepts.add(dept);
            }
        }
        findChildren(sysDepts, depts);
        return sysDepts;
    }

    private void findChildren(List<MSysDept> sysDepts, List<MSysDept> depts) {
        for (MSysDept sysDept : sysDepts) {
            List<MSysDept> children = new ArrayList<>();
            for (MSysDept dept : depts) {
                if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
                    dept.setParentName(dept.getName());
                    dept.setLevel(sysDept.getLevel() + 1);
                    children.add(dept);
                }
            }
            sysDept.setChildren(children);
            findChildren(children, depts);
        }
    }
}
