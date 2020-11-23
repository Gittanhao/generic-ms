package com.dong.genadmin.service;

import com.dong.genadmin.generator.model.SysConfig;
import com.dong.gencore.service.CurdService;

import java.util.List;

/**
 * @Classname SysConfigService
 * @Description TODO 系统配置
 * @Date 2019/10/3 10:45
 * @Created by dong
 */
public interface SysConfigService extends CurdService<SysConfig> {

    List<SysConfig> findByLabel(String label);
}
