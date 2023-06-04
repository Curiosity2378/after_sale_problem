package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.controller;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Goods;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.GoodsService;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils.JsonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @PostMapping
    public String addGoods(@RequestBody Goods goods){
        return JsonUtil.toJson(goodsService.addGoods(goods));
    }

    @DeleteMapping("/{id}")
    public String removeGoods(@PathVariable Integer id){
        return JsonUtil.toJson(goodsService.removeGoods(id));
    }

    @PutMapping("/delete")
    public String removeAnyGoods(@RequestBody List<Integer> goodsIds){
        return JsonUtil.toJson(goodsService.removeAnyGoods(goodsIds));
    }

    @PutMapping
    public String updateGoods(@RequestBody Goods goods){
        return JsonUtil.toJson(goodsService.updateGoods(goods));
    }

    @PostMapping("/goodsCount")
    public String goodsCount(@RequestBody Goods goods){
        return JsonUtil.toJson(goodsService.queryGoodsCount(goods));
    }

    @PostMapping("/condition/{pageNum}")
    public String goodsByCondition(@RequestBody Goods goods,@PathVariable("pageNum") Integer pageNum) {
        return JsonUtil.toJson(goodsService.selectGoodsByCondition(goods,pageNum));
    }
}
