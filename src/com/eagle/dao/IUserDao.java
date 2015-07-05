package com.eagle.dao;

import com.eagle.service.bean.User;

public interface IUserDao {
	void saveUser(User user) throws Exception;
	User findUserByName(String name) throws Exception;
}
