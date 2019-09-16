package com.ling.service.o2o.impl;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.ling.enity.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {

    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        classes.add(Seller.class);
        classes.add(SellerSupports.class);
        classes.add(Goods.class);
        classes.add(Foods.class);
        classes.add(Ratings.class);
        classes.add(UserInfo.class);
        return classes;
    }
}