package com.dong.genadmin.controller;

import com.dong.genadmin.generator.model.SysConfig;
import com.dong.genadmin.service.SysConfigService;
import com.dong.gencore.http.HttpResult;
import com.dong.gencore.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname SysConfigController
 * @Description TODO
 * @Date 2019/10/3 10:37
 * @Created by dong
 */
@RestController
@RequestMapping("config")
public class SysConfigController {
    @Resource
    private SysConfigService sysConfigService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysConfig record) {
        return HttpResult.ok(sysConfigService.save(record));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody SysConfig record) {
        return HttpResult.ok(sysConfigService.delete(record));
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysConfigService.findPage(pageRequest));
    }

    @GetMapping("/findByLabel")
    public HttpResult findByLabel(@RequestParam String label) {
        return HttpResult.ok(sysConfigService.findByLabel(label));
    }
}
