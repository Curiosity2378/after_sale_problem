package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils;

import com.google.gson.Gson;
import io.jsonwebtoken.*;
import io.jsonwebtoken.gson.io.GsonSerializer;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String createToken(){
        JwtBuilder jwtBuilder = Jwts.builder();
        long time = 1000 * 60 * 60;
        return jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("username","admin")
                .claim("role","admin")
                .setSubject("access_token")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(key)
                .serializeToJsonWith(new GsonSerializer<>(new Gson()))
                .compact();
    }

    public static boolean checkToken(String token){
        if(token == null || token.equals("")){
            return false;
        }
        try{
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
