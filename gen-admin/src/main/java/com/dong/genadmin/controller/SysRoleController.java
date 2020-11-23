package com.dong.genadmin.controller;

import com.dong.genadmin.generator.model.SysRole;
import com.dong.genadmin.generator.model.SysRoleMenu;
import com.dong.genadmin.service.SysRoleService;
import com.dong.gencore.http.HttpResult;
import com.dong.gencore.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysRoleController
 * @Description TODO
 * @Date 2019/10/2 11:05
 * @Created by dong
 */
@RestController
@RequestMapping("role")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysRole record) {
        return HttpResult.ok(sysRoleService.save(record));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody SysRole record) {
        return HttpResult.ok(sysRoleService.delete(record));
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysRoleService.findPage(pageRequest));
    }

    @GetMapping("/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(sysRoleService.findAll());
    }

    @PostMapping("/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam Long roleId) {
        return HttpResult.ok(sysRoleService.findRoleMenus(roleId));
    }

    @PostMapping("/saveRoleMenus")
    public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records) {
        return HttpResult.ok(sysRoleService.saveRoleMenus(records));
    }
}
