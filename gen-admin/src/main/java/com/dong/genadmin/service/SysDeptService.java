package com.dong.genadmin.service;

import com.dong.genadmin.generator.model.SysDept;
import com.dong.genadmin.manual.model.MSysDept;
import com.dong.gencore.service.CurdService;

import java.util.List;

/**
 * @Classname SysDeptService
 * @Description TODO
 * @Date 2019/9/30 16:08
 * @Created by dong
 */
public interface SysDeptService extends CurdService<SysDept> {

    /**
     * 查询机构树
     * @return
     */
    List<MSysDept> findTree();
}
