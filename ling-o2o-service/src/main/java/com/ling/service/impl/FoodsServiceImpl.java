package com.ling.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ling.dao.FoodsDao;
import com.ling.enity.Foods;
import com.ling.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FoodsServiceImpl implements FoodsService {
    @Autowired
    private FoodsDao foodsDao;

    @Override
    public void save(Foods foods) {
        foodsDao.save(foods);
    }
}
