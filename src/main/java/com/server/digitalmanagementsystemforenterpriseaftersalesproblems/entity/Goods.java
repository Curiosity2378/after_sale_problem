package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Goods {
    @TableId(type = IdType.AUTO)
    private Integer goodsId;
    private String goodsName;

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsInformation() {
        return goodsInformation;
    }

    public void setGoodsInformation(String goodsInformation) {
        this.goodsInformation = goodsInformation;
    }

    private String goodsPrice;
    private String goodsInformation;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
