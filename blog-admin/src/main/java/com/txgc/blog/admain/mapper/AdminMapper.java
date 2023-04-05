package com.txgc.blog.admain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.txgc.blog.admain.pojo.Admin;
import com.txgc.blog.admain.pojo.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface AdminMapper extends BaseMapper<Admin> {
    //不写resource中的mapper，也可使用注解
    @Select("select * from ms_permission where id in (select permission_id from ms_admin_permission where admin_id=#{adminId})")
    List<Permission> findPermissionsByAdminId(Long adminId);
}