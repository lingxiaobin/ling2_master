package com.ling.dao;

import com.ling.enity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDao extends JpaRepository<Seller,Long> {
}
