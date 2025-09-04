package vn.iotstart.services.impl;

import vn.iotstart.dao.IUserDao;
import vn.iotstart.dao.impl.UserDaoImpl;
import vn.iotstart.model.UserModel;
import vn.iotstart.services.IUserService;

public class UserServiceImpl implements IUserService{
IUserDao userDao = new UserDaoImpl();
	
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		
		return userDao.findByUserName(username);
	}

}
