package com.dong.genadmin.controller;

import com.dong.genadmin.generator.model.SysDict;
import com.dong.genadmin.service.SysDictService;
import com.dong.gencore.http.HttpResult;
import com.dong.gencore.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Classname SysDictController
 * @Description TODO 字典管理控制器
 * @Date 2019/9/29 10:02
 * @Created by dong
 */
@RestController
@RequestMapping("dict")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;

    @GetMapping(value="/findByLabel")
    public HttpResult findByLable(@RequestParam String lable) {
        return HttpResult.ok(sysDictService.findByLabel(lable));
    }

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.delete(record));
    }

    @PostMapping(value = "/deleteBatch")
    public HttpResult deleteBatch(@RequestBody List<SysDict> records) {
        return HttpResult.ok(sysDictService.delete(records));
    }

    @GetMapping(value = "/findById")
    public HttpResult findById(@RequestParam Long id) {
        return HttpResult.ok(sysDictService.findById(id));
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }
}
