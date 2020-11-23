package com.dong.genadmin.generator.mapper;

import com.dong.genadmin.generator.model.SysDict;
import org.apache.ibatis.annotations.Mapper;

public interface SysDictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);
}