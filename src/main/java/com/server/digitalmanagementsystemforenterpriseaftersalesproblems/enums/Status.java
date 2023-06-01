package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Status {
    UNTREATED(1,"未处理"),PROCESSING(2,"处理中"),PROCESSED(3,"已处理");
    @EnumValue
    private Integer code;
    private String desc;

    public String getDesc() {
        return desc;
    }

    private Status(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
