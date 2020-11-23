package com.dong.genadmin.manual.mapper;

import com.dong.genadmin.generator.model.SysDept;
import com.dong.genadmin.manual.model.MSysDept;

import java.util.List;

/**
 * @Classname MSysDeptMapper
 * @Description TODO
 * @Date 2019/9/30 15:44
 * @Created by dong
 */
public interface MSysDeptMapper {
    /**
     * 查询所有
     * @return
     */
    List<MSysDept> findAll();

    /**
     * 分页
     * @return
     */
    List<SysDept> findPage();
}
