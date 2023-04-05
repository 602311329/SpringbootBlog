package com.txgc.blog.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    //设置密钥，相当于JWT中的C（密钥不暴露给别人，JWT字段就是安全的）
    private static final String jwtToken = "123456Mszlu!@#$$";

    public static String createToken(Long userId){
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId",userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken) // 签发算法，秘钥为jwtToken
                .setClaims(claims) // body数据，要唯一，自行设置
                .setIssuedAt(new Date()) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 60 * 1000));// 一天的有效时间
        String token = jwtBuilder.compact();
        return token;
    }

    public static Map<String, Object> checkToken(String token){
        try {
            //用密钥解析token
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            //解析失败
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 验证JWT
     * @param args
     */
    public static void main(String[] args) {
        String token=JWTUtils.createToken(100L);
        System.out.println(token);
        Map<String, Object> map = JWTUtils.checkToken(token);
        System.out.println(map.get("userId"));
        String slat = "txgcsql!@#";
        String password="12abcdef";
        System.out.println("前"+password);
        password= DigestUtils.md2Hex(password+slat);
        System.out.println("后"+password);
    }

}