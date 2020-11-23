package com.dong.genadmin.controller;

import com.dong.genadmin.generator.model.SysLoginLog;
import com.dong.genadmin.service.SysLoginLogService;
import com.dong.gencore.http.HttpResult;
import com.dong.gencore.page.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname SysLoginLogController
 * @Description TODO
 * @Date 2019/10/3 11:16
 * @Created by dong
 */
@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {
    @Resource
    private SysLoginLogService sysLoginLogService;

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody SysLoginLog record) {
        return HttpResult.ok(sysLoginLogService.delete(record));
    }
}
