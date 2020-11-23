package com.dong.genadmin.service;

import com.dong.genadmin.generator.model.SysDict;
import com.dong.gencore.service.CurdService;

import java.util.List;


/**
 * @Classname SysDictService
 * @Description TODO 数据字典操作 CRUD 接口，继承 CurdService 接口中的方法
 * @Date 2019/9/29 10:03
 * @Created by dong
 */
public interface SysDictService extends CurdService<SysDict> {
    /**
     * 通过标签查询
     * @param label 标签
     * @return
     */
    List<SysDict> findByLabel(String label);
}
