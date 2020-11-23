package com.dong.genadmin.service.impl;

import com.dong.genadmin.generator.model.SysDict;
import com.dong.genadmin.service.SysDictService;
import com.dong.gencore.page.PageRequest;
import com.dong.gencore.page.PageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @Classname SysDictServiceImplTest
 * @Description TODO 测试 Swagger 接口文档访问：http://localhost:80/swagger-ui.html#/
 * @Date 2019/9/29 11:08
 * @Created by dong
 */
@RunWith(SpringRunner.class)  // 需要打上这两个注解
@SpringBootTest
public class SysDictServiceImplTest {
    @Resource
    private SysDictService sysDictService;

    @Test
    public void save() {
        SysDict dict = new SysDict();
        dict.setId((long) 3);
        dict.setValue("male");
        dict.setLabel("男");
        dict.setType("sex");
        dict.setDescription("性别");
        dict.setSort((long) 2);  // 其余字段可为空
        sysDictService.save(dict);
    }

    @Test
    public void delete() {

    }

    @Test
    public void delete1() {
    }

    @Test
    public void findById() {
        SysDict dict = sysDictService.findById((long) 1);
        System.out.println(dict.getRemarks());
    }

    @Test
    public void findPage() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(0);
        pageRequest.setPageSize(3);
        PageResult page = sysDictService.findPage(pageRequest);
        System.out.println(page.getContent());
    }

    @Test
    public void findByLabel() {
    }
}