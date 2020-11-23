package com.dong.genadmin.controller;

import com.dong.genadmin.generator.model.SysMenu;
import com.dong.genadmin.service.SysMenuService;
import com.dong.gencore.http.HttpResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname SysMenuController
 * @Description TODO
 * @Date 2019/10/2 16:43
 * @Created by dong
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysMenu record) {
        return HttpResult.ok(sysMenuService.save(record));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody SysMenu record) {
        return HttpResult.ok(sysMenuService.delete(record));
    }

    @GetMapping("/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    @GetMapping("/findMenuTree")
    public HttpResult findMenuTree() {
        return HttpResult.ok(sysMenuService.findTree(null, 0));
    }

}
