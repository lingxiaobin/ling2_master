package com.ling.service.o2o.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.ling.dao.UserInfoDao;
import com.ling.enity.UserInfo;
import com.ling.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 服务层接口
 * @author Administrator
 *
 */
@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public String findAll() {
		UserInfo userInfo=userInfoDao.findByUserName("sss");

		return JSON.toJSONString(userInfo);
	}
}
