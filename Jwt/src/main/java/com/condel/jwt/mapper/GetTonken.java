package com.condel.jwt.mapper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.condel.jwt.pojo.User;
import org.springframework.stereotype.Component;


@Component
public class GetTonken {


    /**
     * 自定义创建令牌
     *
     * @param user 用户
     * @return {@link String}
     * <p>
     * Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端。
     * withAudience()存入需要保存在token的信息，这里我把用户ID存入token中
     */
    public String getToken(User user) {
        String token = "";
        //jwt创建一个token，创建条件是withAudience(user.getId(),user.getUsername())
        // 使用sign(Algorithm.HMAC256(user.getPassword()))使用算法加密密码     签署签名
        // create是最后还要根据heard头的算法来加密
        token = JWT.create().withAudience(user.getId(), user.getUsername()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
