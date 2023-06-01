package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Goods;

import java.util.List;

public interface GoodsService {
    boolean addGoods(Goods goods);
    boolean removeGoods(Integer goodsId);
    boolean removeAnyGoods(List<Integer> goodsIds);
    boolean updateGoods(Goods goods);
    Long queryGoodsCount(Goods goods);
    List<Goods> selectGoodsByCondition(Goods goods,Integer pageNum);
}
