package com.eagle.service.impl;

import com.eagle.dao.IUserDao;
import com.eagle.dao.impl.IUserDaoImpl;
import com.eagle.service.IUserService;
import com.eagle.service.bean.User;

//负责业务逻辑处理
public class UserServiceImpl implements IUserService {
	private IUserDao dao = new IUserDaoImpl();

	public void register(User user) throws Exception {

		User u = dao.findUserByName(user.getName());
		if (u != null) {
			throw new Exception("用户已被占用");
		}
		dao.saveUser(user);

	}

}
