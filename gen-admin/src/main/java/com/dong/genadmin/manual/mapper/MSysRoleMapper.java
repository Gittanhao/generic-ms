package com.dong.genadmin.manual.mapper;

import com.dong.genadmin.generator.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname MSysRoleMapper
 * @Description TODO
 * @Date 2019/10/2 10:30
 * @Created by dong
 */
public interface MSysRoleMapper {
    /**
     * 查询所有
     * @return
     */
    List<SysRole> findAll();

    List<SysRole> findPage();

    /**
     * 根据名字分页查找
     * @param name
     * @return
     */
    List<SysRole> findPageByName(@Param(value = "name") String name);

}
