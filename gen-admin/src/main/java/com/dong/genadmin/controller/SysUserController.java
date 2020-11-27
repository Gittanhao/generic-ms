package com.dong.genadmin.controller;

import com.dong.genadmin.generator.model.SysUser;
import com.dong.genadmin.service.SysUserService;
import com.dong.gencore.http.HttpResult;
import com.dong.gencore.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * @Classname SysUserController
 * @Description TODO
 * @Date 2019/9/30 15:23
 * @Created by dong
 */
@RestController
@RequestMapping("user")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @GetMapping(value = "/findByName")
    public HttpResult findByName(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findByName(name));
    }

    @GetMapping(value = "/findByid")
    public HttpResult findByid(@RequestParam Long id) {
        return HttpResult.ok(sysUserService.findByid(id));
    }

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysUser record) {
        return HttpResult.ok(sysUserService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody SysUser record) {
        return HttpResult.ok(sysUserService.delete(record));
    }

    @PostMapping(value = "/deleteBatch")
    public HttpResult deleteBatch(@RequestBody List<SysUser> records) {
        return HttpResult.ok(sysUserService.delete(records));
    }

    @GetMapping(value = "/findById")
    public HttpResult findById(@RequestParam Long id) {
        return HttpResult.ok(sysUserService.findById(id));
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

    @GetMapping("/findPermissions")
    public HttpResult findPermissions(@RequestParam String name) {
        Set<String> permissions = sysUserService.findPermissions(name);
//        System.out.println(permissions);
        return HttpResult.ok(permissions);
    }

    @GetMapping("/findUserRoles")
    public HttpResult findUserRoles(@RequestParam Long userId) {
        return HttpResult.ok(sysUserService.findUserRoles(userId));
    }

    @PostMapping(value = "/longin")
    public HttpResult longin(@RequestBody SysUser user) {
        List<SysUser> users = sysUserService.findByName(user.getName());
        if (users != null && users.size() > 0) {
            return HttpResult.ok();
        }
        return HttpResult.error(9999, "用户不存在,请检查您的账号和密码");
    }

    @PostMapping(value = "/exportUsers")
    public void exportUsers(HttpServletResponse response,@RequestBody PageRequest pageRequest) {
        sysUserService.exportUsers(response,pageRequest);
    }

//    @GetMapping(value = "/findAllUsers")
//    public HttpResult findAllUsers() {
//        return HttpResult.ok(sysUserService.findAllUsers());
//    }
}
