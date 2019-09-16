package com.ling.service.o2o.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.ling.dao.FoodsDao;
import com.ling.dao.GoodsDao;
import com.ling.enity.Foods;
import com.ling.enity.Goods;
import com.ling.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(timeout =10000 )
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private FoodsDao foodsDao;
    @Override
    public Goods save(Goods goods) {
        return goodsDao.save(goods);
    }

    @Override
    public String save(String goods) {
        List<Goods> goodsList=JSON.parseArray(goods,Goods.class);
        for (Goods goods1:goodsList) {
            for(Foods foods:goods1.getFoodsList()){
                foods.setGoods(goods1);
                foodsDao.save(foods);
            }
        }
//        return JSON.toJSONString(goodsDao.save(goodsList));
        return "dddd";
    }

    @Override
    public String save(List<Foods> list) {
        return list.size()+"";
    }
}
