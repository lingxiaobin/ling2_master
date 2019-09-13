package com.ling.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ling.dao.SellerDao;
import com.ling.enity.Seller;
import com.ling.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDao sellerDao;
    @Override
    public Seller save(Seller seller) {
        return  sellerDao.save(seller);
    }

    @Override
    public Seller findSellerByid(Long id) {
        return sellerDao.findOne(id);
    }
}
