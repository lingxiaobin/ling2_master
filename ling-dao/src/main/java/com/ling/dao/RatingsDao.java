package com.ling.dao;

import com.ling.enity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsDao extends JpaRepository<Ratings,Long> {
}
