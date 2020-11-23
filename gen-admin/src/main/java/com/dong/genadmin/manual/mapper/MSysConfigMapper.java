package com.dong.genadmin.manual.mapper;

import com.dong.genadmin.generator.model.SysConfig;

import java.util.List;

/**
 * @Classname MSysConfigMapper
 * @Description TODO
 * @Date 2019/10/3 10:54
 * @Created by dong
 */
public interface MSysConfigMapper {

    List<SysConfig> findPage();

    List<SysConfig> findByLabel(String label);
}
