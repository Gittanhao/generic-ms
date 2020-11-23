
 --------------------------------------------
|  generic-ms 通用后台管理系统 数据库表设计  |
 --------------------------------------------

	DROP TABLE IF EXISTS `sys_config`;
	CREATE TABLE `sys_config` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `value` varchar(100) NOT NULL COMMENT '数据值',
	  `label` varchar(100) NOT NULL COMMENT '标签名',
	  `type` varchar(100) NOT NULL COMMENT '类型',
	  `description` varchar(100) NOT NULL COMMENT '描述',
	  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
	  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='系统配置表';

	
	INSERT INTO `sys_config` VALUES ('1', '#14889A', 'theme', 'color', '主题色', '0', 'admin', '2019-09-23 19:52:54', null, null, '主题色', '0');

	DROP TABLE IF EXISTS `sys_dept`;
	CREATE TABLE `sys_dept` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `name` varchar(50) DEFAULT NULL COMMENT '机构名称',
	  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
	  `order_num` int(11) DEFAULT NULL COMMENT '排序',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='机构管理';

	INSERT INTO `sys_dept` VALUES ('1', '轻尘集团', null, '0', 'admin', '2019-09-23 19:35:22', null, null, '0');
	INSERT INTO `sys_dept` VALUES ('2', '牧尘集团', null, '1', 'admin', '2019-09-23 19:35:55', null, null, '0');
	INSERT INTO `sys_dept` VALUES ('3', '三国集团', null, '2', 'admin', '2019-09-23 19:36:24', null, null, '0');
	INSERT INTO `sys_dept` VALUES ('4', '上海分公司', '2', '0', 'admin', '2019-09-23 19:37:03', null, null, '0');
	INSERT INTO `sys_dept` VALUES ('5', '北京分公司', '1', '1', 'admin', '2019-09-23 19:37:17', null, null, '0');
	INSERT INTO `sys_dept` VALUES ('6', '北京分公司', '2', '1', 'admin', '2019-09-23 19:37:28', null, null, '0');
	INSERT INTO `sys_dept` VALUES ('7', '技术部', '5', '0', 'admin', '2019-09-23 19:38:00', null, null, '0');
	INSERT INTO `sys_dept` VALUES ('8', '技术部', '4', '0', 'admin', '2019-09-23 19:38:10', null, null, '0');
	INSERT INTO `sys_dept` VALUES ('9', '技术部', '6', '0', 'admin', '2019-09-23 19:38:17', null, null, '0');



	DROP TABLE IF EXISTS `sys_dict`;
	CREATE TABLE `sys_dict` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `value` varchar(100) NOT NULL COMMENT '数据值',
	  `label` varchar(100) NOT NULL COMMENT '标签名',
	  `type` varchar(100) NOT NULL COMMENT '类型',
	  `description` varchar(100) NOT NULL COMMENT '描述',
	  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
	  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='字典表';

	
	INSERT INTO `sys_dict` VALUES ('1', 'male', '男', 'sex', '性别', '0', 'admin', '2019-09-23 19:52:54', null, null, '性别', '0');
	INSERT INTO `sys_dict` VALUES ('2', 'female', '女', 'sex', '性别', '1', 'admin', '2019-09-23 19:53:17', null, null, '性别', '0');


	DROP TABLE IF EXISTS `sys_log`;
	CREATE TABLE `sys_log` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
	  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
	  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
	  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
	  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
	  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=2897 DEFAULT CHARSET=utf8 COMMENT='系统操作日志';

	INSERT INTO `sys_log` VALUES ('1', 'admin', null, 'com.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()', '{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2019-09-23 19:54:16', null, null);
	INSERT INTO `sys_log` VALUES ('2', 'admin', null, 'com.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()', '{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}', '4', '0:0:0:0:0:0:0:1', 'admin', '2019-09-23 19:54:17', null, null);



	DROP TABLE IF EXISTS `sys_login_log`;
	CREATE TABLE `sys_login_log` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
	  `status` varchar(50) DEFAULT NULL COMMENT '登录状态（online:在线，登录初始状态，方便统计在线人数；login:退出登录后将online置为login；logout:退出登录）',
	  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=2804 DEFAULT CHARSET=utf8 COMMENT='系统登录日志';

	INSERT INTO `sys_login_log` VALUES ('1', 'admin', 'login', '0:0:0:0:0:0:0:1', 'admin', '2019-09-23 19:54:16', null, null);
	INSERT INTO `sys_login_log` VALUES ('2', 'admin', 'logout', '0:0:0:0:0:0:0:1', 'admin', '2019-09-23 19:54:17', null, null);




	DROP TABLE IF EXISTS `sys_menu`;
	CREATE TABLE `sys_menu` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
	  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
	  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)',
	  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)',
	  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
	  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
	  `order_num` int(11) DEFAULT NULL COMMENT '排序',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='菜单管理';


	INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', null, null, '0', 'el-icon-setting', '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('2', '用户管理', '1', '/sys/user', null, '1', 'el-icon-service', '1', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('3', '查看', '2', null, 'sys:user:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('4', '新增', '2', null, 'sys:user:add', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('5', '修改', '2', null, 'sys:user:edit', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('6', '删除', '2', null, 'sys:user:delete', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('7', '机构管理', '1', '/sys/dept', null, '1', 'el-icon-news', '2', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('8', '查看', '7', null, 'sys:dept:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('9', '新增', '7', null, 'sys:dept:add', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('10', '修改', '7', null, 'sys:dept:edit', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('11', '删除', '7', null, 'sys:dept:delete', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('12', '角色管理', '1', '/sys/role', null, '1', 'el-icon-view', '4', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('13', '查看', '12', null, 'sys:role:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('14', '新增', '12', null, 'sys:role:add', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('15', '修改', '12', null, 'sys:role:edit', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('16', '删除', '12', null, 'sys:role:delete', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('17', '菜单管理', '1', '/sys/menu', null, '1', 'el-icon-menu', '5', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('18', '查看', '17', null, 'sys:menu:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('19', '新增', '17', null, 'sys:menu:add', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('20', '修改', '17', null, 'sys:menu:edit', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('21', '删除', '17', null, 'sys:menu:delete', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('22', '字典管理', '1', '/sys/dict', null, '1', 'el-icon-edit-outline', '7', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('23', '查看', '22', null, 'sys:dict:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('24', '新增', '22', null, 'sys:dict:add', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('25', '修改', '22', null, 'sys:dict:edit', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('26', '删除', '22', null, 'sys:dict:delete', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('27', '系统配置', '1', '/sys/config', null, '1', 'el-icon-edit-outline', '7', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('28', '查看', '27', null, 'sys:config:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('29', '新增', '27', null, 'sys:config:add', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('30', '修改', '27', null, 'sys:config:edit', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('31', '删除', '27', null, 'sys:config:delete', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('32', '登录日志', '1', '/sys/loginlog', null, '1', 'el-icon-info', '8', null, null, 'admin', '2019-09-23 19:32:28', '0');
	INSERT INTO `sys_menu` VALUES ('33', '查看', '32', null, 'sys:loginlog:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('34', '删除', '32', null, 'sys:loginlog:delete', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('35', '操作日志', '1', '/sys/log', null, '1', 'el-icon-info', '8', null, null, 'admin', '2019-09-23 19:32:28', '0');
	INSERT INTO `sys_menu` VALUES ('36', '查看', '35', null, 'sys:log:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('37', '删除', '35', null, 'sys:log:delete', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('38', '系统监控', '0', '', '', '0', 'el-icon-info', '4', 'admin', '2019-12-27 10:57:29', 'admin', '2019-01-10 17:31:04', '0');
	INSERT INTO `sys_menu` VALUES ('39', '数据监控', '38', 'http://127.0.0.1:8001/druid/login.html', null, '1', 'el-icon-warning', '0', null, null, 'admin', '2019-12-27 11:03:45', '0');
	INSERT INTO `sys_menu` VALUES ('40', '查看', '39', null, 'sys:druid:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('41', '服务监控', '38', 'http://127.0.0.1:8000/', null, '1', 'el-icon-view', '1', 'admin', '2019-11-02 20:02:15', 'admin', '2019-12-27 11:03:53', '0');
	INSERT INTO `sys_menu` VALUES ('42', '查看', '41', null, 'sys:monitor:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('43', '服务治理', '0', '', '', '0', 'el-icon-service', '2', 'admin', '2019-12-27 11:05:48', 'admin', '2019-12-27 11:06:39', '0');
	INSERT INTO `sys_menu` VALUES ('44', '注册中心', '43', 'http://127.0.0.1:8500', null, '1', ' el-icon-view', '0', 'admin', '2019-11-03 11:06:48', 'admin', '2019-12-27 11:08:11', '0');
	INSERT INTO `sys_menu` VALUES ('45', '查看', '44', null, 'sys:consul:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('46', '接口文档', '0', 'http://127.0.0.1:8001/swagger-ui.html', null, '1', 'el-icon-document', '3', null, null, 'admin', '2019-12-27 11:04:18', '0');
	INSERT INTO `sys_menu` VALUES ('47', '查看', '46', null, 'sys:swagger:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('48', '代码生成', '0', '/generator/generator', '', '1', 'el-icon-star-on', '5', 'admin', '2019-11-15 14:39:30', 'admin', '2019-11-15 14:56:18', '0');
	INSERT INTO `sys_menu` VALUES ('49', '查看', '48', null, 'sys:generator:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('50', '在线用户', '0', '/sys/online', '', '1', 'el-icon-view', '5', 'admin', '2019-11-15 14:39:30', 'admin', '2019-11-15 14:56:18', '0');
	INSERT INTO `sys_menu` VALUES ('51', '查看', '50', null, 'sys:online:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('52', '使用案例', '0', null, null, '0', 'el-icon-picture-outline', '6', null, null, 'admin', '2019-11-15 14:39:43', '0');
	INSERT INTO `sys_menu` VALUES ('53', '国际化', '52', '/demo/i18n', null, '1', 'el-icon-edit', '1', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('54', '查看', '53', null, 'sys:dict:view', '2', null, '0', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('55', '换皮肤', '52', '/demo/theme', null, '1', 'el-icon-picture', '2', null, null, null, null, '0');
	INSERT INTO `sys_menu` VALUES ('56', '查看', '55', null, 'sys:dict:view', '2', null, '0', null, null, null, null, '0');



	DROP TABLE IF EXISTS `sys_role`;
	CREATE TABLE `sys_role` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
	  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色管理';

	
	INSERT INTO `sys_role` VALUES ('1', 'admin', '超级管理员', 'admin', '2019-01-19 11:11:11', 'admin', '2019-01-19 19:07:18', '0');
	INSERT INTO `sys_role` VALUES ('2', 'mng', '项目经理', 'admin', '2019-01-19 11:11:11', 'admin', '2019-01-19 11:39:28', '0');
	INSERT INTO `sys_role` VALUES ('3', 'dev', '开发人员', 'admin', '2019-01-19 11:11:11', 'admin', '2019-01-19 11:39:28', '0');
	INSERT INTO `sys_role` VALUES ('4', 'test', '测试人员', 'admin', '2019-01-19 11:11:11', 'admin', '2019-01-19 11:11:11', '0');



	DROP TABLE IF EXISTS `sys_role_dept`;
	CREATE TABLE `sys_role_dept` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
	  `dept_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色机构';


	INSERT INTO `sys_role_dept` VALUES ('1', '1', '1', 'admin', '2019-01-11 08:30:37', 'admin', '2019-01-11 08:30:25');
	INSERT INTO `sys_role_dept` VALUES ('2', '2', '2', 'admin', '2019-01-11 08:31:01', 'admin', '2019-01-11 08:31:04');
	INSERT INTO `sys_role_dept` VALUES ('3', '3', '3', 'admin', '2019-01-11 08:31:18', 'admin', '2019-01-11 08:31:21');



	DROP TABLE IF EXISTS `sys_role_menu`;
	CREATE TABLE `sys_role_menu` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
	  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=623 DEFAULT CHARSET=utf8 COMMENT='角色菜单';

	INSERT INTO `sys_role_menu` VALUES ('469', '2', '1', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('470', '2', '2', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('471', '2', '3', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('472', '2', '4', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('473', '2', '5', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('474', '2', '6', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('475', '2', '7', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('476', '2', '8', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('477', '2', '9', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('478', '2', '10', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('479', '2', '11', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('480', '2', '12', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('481', '2', '13', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('482', '2', '14', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('483', '2', '15', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('484', '2', '16', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('485', '2', '17', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('486', '2', '18', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('487', '2', '19', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('488', '2', '20', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('489', '2', '21', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('490', '2', '22', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('491', '2', '23', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('492', '2', '24', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('493', '2', '25', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('494', '2', '26', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('495', '2', '27', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('496', '2', '28', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('497', '2', '29', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('498', '2', '30', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('499', '2', '31', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('500', '2', '32', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('501', '2', '33', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('502', '2', '34', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('503', '2', '35', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('504', '2', '36', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('505', '2', '37', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('506', '2', '43', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('507', '2', '44', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('508', '2', '45', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('509', '2', '46', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('510', '2', '47', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('511', '2', '38', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('512', '2', '39', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('513', '2', '40', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('514', '2', '41', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('515', '2', '42', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('516', '2', '48', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('517', '2', '49', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('518', '2', '50', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('519', '2', '51', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('520', '2', '52', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('521', '2', '53', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('522', '2', '54', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('523', '2', '55', null, null, null, null);
	INSERT INTO `sys_role_menu` VALUES ('524', '2', '56', null, null, null, null);


	DROP TABLE IF EXISTS `sys_user`;
	CREATE TABLE `sys_user` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `name` varchar(50) NOT NULL COMMENT '用户名',
	  `nick_name` varchar(150) DEFAULT NULL COMMENT '昵称',
	  `avatar` varchar(150) DEFAULT NULL COMMENT '头像',
	  `password` varchar(100) DEFAULT NULL COMMENT '密码',
	  `salt` varchar(40) DEFAULT NULL COMMENT '加密盐',
	  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
	  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
	  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
	  `dept_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `name` (`name`)
	) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='用户管理';

	INSERT INTO `sys_user` VALUES ('1', 'admin', '超管', null, 'bd1718f058d8a02468134432b8656a86', 'YzcmCZNvbXocrsz9dm8e', 'admin@qq.com', '13612345678', '1', '4', 'admin', '2019-08-14 11:11:11', 'admin', '2019-08-14 11:11:11', '0');
	INSERT INTO `sys_user` VALUES ('22', 'liubei', '刘备', null, 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '7', 'admin', '2019-09-23 19:43:00', 'admin', '2019-01-10 11:41:13', '0');
	INSERT INTO `sys_user` VALUES ('23', 'zhaoyun', '赵云', null, 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '7', 'admin', '2019-09-23 19:43:44', 'admin', '2019-09-23 19:43:52', '0');
	INSERT INTO `sys_user` VALUES ('24', 'zhugeliang', '诸葛亮', null, 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '7', '11', 'admin', '2019-09-23 19:44:23', 'admin', '2019-09-23 19:44:29', '0');
	INSERT INTO `sys_user` VALUES ('25', 'caocao', '曹操', null, 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '8', 'admin', '2019-09-23 19:45:32', 'admin', '2019-01-10 17:59:14', '0');
	INSERT INTO `sys_user` VALUES ('26', 'dianwei', '典韦', null, 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '10', 'admin', '2019-09-23 19:45:48', 'admin', '2019-09-23 19:45:57', '0');
	INSERT INTO `sys_user` VALUES ('27', 'xiahoudun', '夏侯惇', null, 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', 'test@qq.com', '13889700023', '1', '8', 'admin', '2019-09-23 19:46:09', 'admin', '2019-09-23 19:46:17', '0');



	DROP TABLE IF EXISTS `sys_user_role`;
	CREATE TABLE `sys_user_role` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
	  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
	  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
	  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
	  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COMMENT='用户角色';

	INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, null, null, null);
	INSERT INTO `sys_user_role` VALUES ('2', '2', '1', null, null, null, null);
	INSERT INTO `sys_user_role` VALUES ('26', '5', '3', null, null, null, null);
	INSERT INTO `sys_user_role` VALUES ('33', '6', '2', null, null, null, null);
	INSERT INTO `sys_user_role` VALUES ('34', '4', '2', null, null, null, null);
