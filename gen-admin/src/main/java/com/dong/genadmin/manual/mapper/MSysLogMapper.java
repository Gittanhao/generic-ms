package com.dong.genadmin.manual.mapper;

import com.dong.genadmin.generator.model.SysLog;
import java.util.List;

/**
 * @Classname MSysLogMapper
 * @Description TODO
 * @Date 2019/10/3 11:38
 * @Created by dong
 */
public interface MSysLogMapper {

    List<SysLog> findPage();
}
