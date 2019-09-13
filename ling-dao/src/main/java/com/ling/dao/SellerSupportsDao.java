package com.ling.dao;

import com.ling.enity.SellerSupports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerSupportsDao extends JpaRepository<SellerSupports,Long> {
}
