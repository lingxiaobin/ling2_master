package com.ling.service;

import com.ling.enity.Seller;

public interface SellerService {
    Seller save(Seller seller);

    Seller findSellerByid(Long id);
}
