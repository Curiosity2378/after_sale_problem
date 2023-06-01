package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class MailUtil{
    @Resource
    private JavaMailSender sender;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Value("${spring.mail.username}")
    private String email;

    public void sendVerifyCode(String mail) {
        System.out.println(stringRedisTemplate);
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件标题
        message.setSubject("【企业售后问题后台管理系统】验证码");
        //设置随机数作为验证码
        Random random = new Random();
        int code = random.nextInt(89999) + 10000;
        //将验证码存储到redis中
        stringRedisTemplate.opsForValue().set(mail,String.valueOf(code),5,TimeUnit.MINUTES);
        //邮件内容
        message.setText("您的验证码是："+code+"，五分钟有效，请及时完成注册。若不是本人操作请忽略");
        //设置发送邮箱，和配置文件中的账号一致
        message.setFrom(email);
        //设置接收邮箱
        message.setTo(mail);
        sender.send(message);
    }
}
