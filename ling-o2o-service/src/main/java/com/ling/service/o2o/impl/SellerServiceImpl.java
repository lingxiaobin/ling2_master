package com.ling.service.o2o.impl;

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

//    @Transactional
    @Override
    public Seller findSellerByid(Long id) {
        Seller seller=sellerDao.findOne(id);
//        seller.getSellerSupportsList().size();
//        seller.getFoodsList().size();
        Seller ss=new Seller();
        ss.setName("12434");
        Seller s2=sellerDao.save(ss);
        System.out.println(s2.getId());
//        if (s2.getId()!=1){
//            throw new RuntimeException("测试事务");
//        }
        return seller;
    }
}
