package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Gender {
    MALE(0,"男"),FEMALE(1,"女");
    @EnumValue
    private Integer code;
    private String desc;

    public String getDesc() {
        return desc;
    }

    private Gender(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
