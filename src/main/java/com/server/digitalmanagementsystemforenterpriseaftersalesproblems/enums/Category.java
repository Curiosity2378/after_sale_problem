package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Category {
    RETURN(1,"退货"),EXCHANGE(2,"换货"),MAINTAIN(3,"维修");
    @EnumValue
    private Integer code;
    private String desc;

    public String getDesc() {
        return desc;
    }

    private Category(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
