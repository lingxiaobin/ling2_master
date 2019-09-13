package com.ling.dao;

import com.ling.enity.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodsDao extends JpaRepository<Foods,Long> {
}
