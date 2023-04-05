package com.txgc.blog.admain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.txgc.blog.admain.mapper.AdminMapper;
import com.txgc.blog.admain.mapper.PermissionMapper;
import com.txgc.blog.admain.pojo.Admin;
import com.txgc.blog.admain.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    public Admin findAdminByUserName(String username){
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,username).last("limit 1");
        Admin adminUser = adminMapper.selectOne(queryWrapper);
        return adminUser;
    }

    public List<Permission> findPermissionsByAdminId(Long adminId){
        //select * from ms_permission where id in (select permission_id from ms_admin_permission where admin_id=#{adminId})
        return adminMapper.findPermissionsByAdminId(adminId);
    }

}
