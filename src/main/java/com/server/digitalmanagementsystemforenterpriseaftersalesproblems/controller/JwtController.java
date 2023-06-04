package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.controller;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils.JsonUtil;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jwt")
public class JwtController {
    @GetMapping
    public String sendMail(@RequestHeader("accessToken") String token){
        return JsonUtil.toJson(JwtUtil.checkToken(token));
    }
}
