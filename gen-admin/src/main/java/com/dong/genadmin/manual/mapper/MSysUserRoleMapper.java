package com.dong.genadmin.manual.mapper;

import com.dong.genadmin.generator.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname MSysUserRoleMapper
 * @Description TODO
 * @Date 2019/10/2 12:06
 * @Created by dong
 */
public interface MSysUserRoleMapper {

    List<SysUserRole> findUserRoles(@Param(value = "userId") Long userId);

}
