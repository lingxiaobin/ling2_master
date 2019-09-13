package com.ling.dao;

import com.ling.enity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, String> {
    UserInfo findByUserName(String userName);
}

