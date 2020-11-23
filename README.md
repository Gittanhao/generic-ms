# generic-ms 通用后台管理系统

### 简介

​	企业项目的开发通常有一些基础管理如用户管理、机构管理、角色菜单管理、字典管理、系统配置、登录日志、操作日志等。generic-ms 使用Spring Boot 及 Maven 快速构建了这些基础模块。

### 如何启动

1. 克隆项目到本地

   ```
   git clone https://github.com/comeCU/generic-ms.git
   ```

2. 将项目导入 IDEA 开发工具，修改 generatorDatasource.properties 文件数据源配置信息和 application.yml 文件配置。

3. 在MySQL数据库中运行 doc 目录下的 SQL 文件。

4. 现在该项目可以正常运行了。

   - [访问Swagger](http://localhost/druid/login.html) : `http://localhost/swagger-ui.html#/`
   - [访问Druid监控](http://localhost/druid/login.html) : `http://localhost/druid/login.html`

5. 如果需要添加额外的需求，可以更改 generatorConfig.xml 文件中的内容，如下

   ```xml
   <!-- 生成数据库中所有表的model,mapper -->
   <table tableName="%"
       enableCountByExample="false" enableUpdateByExample="false"
       enableDeleteByExample="false" enableSelectByExample="false"
       selectByExampleQueryId="false">
   </table>
   ```

   将 `tableName="%"` 更改为 `tableName="你的表名"`， 双击IDEA右侧 Maven 下的 mybatis-generator 即可将你的需求补充到项目中，简洁高效。

### 你将收获什么

- 对 HTTP 请求的状态码、消息、返回数据进行了统一封装。
- 使用 PageHelper 封装了分页操作，让分页变得更加简单高效。
- 集成 Druid 数据库连接池，对SQL的执行进行监控。
- 使用 Mybatis-Generator 将 mapper 层开发效率提升至少 50%，将自动代码生成与手工实现分离，提高了代码的整洁性与可维护性。

### 结语

enjoy it !  :)