package com.ling.controller.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ling.controller.vo.SellerVo;
import com.ling.enity.Seller;
import com.ling.service.SellerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceRef {
    @Reference
    private SellerService sellerService;

    public SellerVo findSellerById(Long id){
        Seller seller=sellerService.findSellerByid(id);

        SellerVo sellerVo=new SellerVo();
        BeanUtils.copyProperties(seller,sellerVo);
        return  sellerVo;
    }
}
