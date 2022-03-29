package com.heshen.Utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private static String secrete = "1234567890";
    public static String getToken(String phone,String secrete){
        String token = JWT.create()//链式编程创建JWTCreator
                .withClaim("phone", phone)//存放 payload 数据
                .sign(Algorithm.HMAC256(secrete)); //使用secrete对称加密生成 signature
        return  token;
    }

    /**
     * 解析token获得里面的payload数据
     */
    public static Map<String,String> parseToken(String token,String secrete){
        HashMap<String, String> map = new HashMap<>();
        //通过secret 和相同的对称加密算法反加密
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(secrete))
                .build().verify(token);
        //获得你储存的payload信息
        String phone = jwt.getClaim("phone").asString();
        map.put("phone",phone);
        return map;
    }

}
