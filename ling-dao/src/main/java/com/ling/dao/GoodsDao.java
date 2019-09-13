package com.ling.dao;

import com.ling.enity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDao extends JpaRepository<Goods,Long> {
}
