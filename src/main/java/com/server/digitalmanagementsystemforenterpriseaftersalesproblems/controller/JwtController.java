package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.controller;

import com.google.gson.Gson;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Resource
    private Gson gson;

    @GetMapping("/check")
    public String sendMail(@RequestHeader("accessToken") String token){
        return gson.toJson(JwtUtil.checkToken(token));
    }
}
