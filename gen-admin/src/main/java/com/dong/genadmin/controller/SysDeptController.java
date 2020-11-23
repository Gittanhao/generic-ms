package com.dong.genadmin.controller;

import com.dong.genadmin.generator.model.SysDept;
import com.dong.genadmin.service.SysDeptService;
import com.dong.gencore.http.HttpResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysDeptController
 * @Description TODO
 * @Date 2019/9/30 16:31
 * @Created by dong
 */
@RestController
@RequestMapping(value = "dept")
public class SysDeptController {
    @Resource
    private SysDeptService sysDeptService;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.delete(record));
    }

    @PostMapping(value = "/deleteBatch")
    public HttpResult deleteBatch(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.delete(records));
    }

    @GetMapping(value = "/findTree")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }
}
