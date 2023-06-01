package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Goods;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.mapper.GoodsMapper;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public boolean addGoods(Goods goods) {
        return goodsMapper.insert(goods) == 1;
    }

    @Override
    public boolean removeGoods(Integer goodsId) {
        return goodsMapper.deleteById(goodsId) == 1;
    }

    @Override
    public boolean removeAnyGoods(List<Integer> goodsIds) {
        return goodsMapper.deleteBatchIds(goodsIds) == goodsIds.size();
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return goodsMapper.updateById(goods) == 1;
    }

    @Override
    public Long queryGoodsCount(Goods goods) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        if(goods.getGoodsName() != ""){
            queryWrapper.eq("goods_name",goods.getGoodsName());
        }
        return goodsMapper.selectCount(queryWrapper);
    }

    @Override
    public List<Goods> selectGoodsByCondition(Goods goods, Integer pageNum) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        if(goods.getGoodsName() != "" && goods.getGoodsName() != null){
            queryWrapper.eq("goods_name",goods.getGoodsName());
        }
        var page = new Page<Goods>(pageNum,10);
        goodsMapper.selectPage(page,queryWrapper);
        return page.getRecords();
    }
}