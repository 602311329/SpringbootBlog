package com.txgc.blog.utils;

import com.txgc.blog.dao.pojo.SysUser;

public class UserThreadlocal {
    private UserThreadlocal(){}
    //线程变量隔离
    private static final ThreadLocal<SysUser> LOCAL=new ThreadLocal<>();
    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }
    public static SysUser get(){
        return LOCAL.get();
    }
    public static void remove(){
        LOCAL.remove();
    }
}
