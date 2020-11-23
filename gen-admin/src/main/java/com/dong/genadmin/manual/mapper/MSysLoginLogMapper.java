package com.dong.genadmin.manual.mapper;

import com.dong.genadmin.generator.model.SysLoginLog;

import java.util.List;

/**
 * @Classname MSysLoginLogMapper
 * @Description TODO
 * @Date 2019/10/3 11:23
 * @Created by dong
 */
public interface MSysLoginLogMapper {

    List<SysLoginLog> findPage();
}
