package com.dong.genadmin.manual.mapper;

import com.dong.genadmin.generator.model.SysDict;

import java.util.List;

/**
 * @Classname MSysDictMapper
 * @Description TODO 手动添加的mapper，不去动mybatis-generator自动生成的代码
 *              另外新建文件存放，在手动添加的mapper文件名前面统一加字母 M ，防止bean 冲突
 * @Date 2019/9/29 9:50
 * @Created by dong
 */
public interface MSysDictMapper {
    /**
     * 通过标签查询
     * @param label 标签
     * @return
     */
    List<SysDict> findByLabel(String label);

    /**
     * 分页
     * @return
     */
    List<SysDict> findPage();
}
