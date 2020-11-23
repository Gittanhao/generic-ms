package com.dong.genadmin.controller;

import com.dong.genadmin.generator.model.SysLog;
import com.dong.genadmin.service.SysLogService;
import com.dong.gencore.http.HttpResult;
import com.dong.gencore.page.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname SysLogController
 * @Description TODO
 * @Date 2019/10/3 11:32
 * @Created by dong
 */
@RestController
@RequestMapping("log")
public class SysLogController {
    @Resource
    private SysLogService sysLogService;

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLogService.findPage(pageRequest));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody SysLog record) {
        return HttpResult.ok(sysLogService.delete(record));
    }
}
