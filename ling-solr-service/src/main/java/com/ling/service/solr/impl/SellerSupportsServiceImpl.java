package com.ling.service.solr.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ling.dao.SellerSupportsDao;
import com.ling.enity.SellerSupports;
import com.ling.service.SellerSupportsService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class SellerSupportsServiceImpl implements SellerSupportsService {
    @Autowired
    private SellerSupportsDao sellerSupportsDao;
    @Override
    public SellerSupports save(SellerSupports sellerSupports) {
        return sellerSupportsDao.save(sellerSupports);
    }
}
