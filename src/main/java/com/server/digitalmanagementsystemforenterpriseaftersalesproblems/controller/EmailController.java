package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.controller;

import com.google.gson.Gson;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils.MailUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Resource
    private MailUtil mailUtil;
    @Resource
    private Gson gson;

    @GetMapping("/{mail}")
    public String sendMail(@PathVariable("mail") String mail){
        try{
            mailUtil.sendVerifyCode(mail);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return gson.toJson(false,Boolean.TYPE);
        }

        return gson.toJson(true,Boolean.TYPE);
    }
}
