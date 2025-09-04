package vn.iotstart.services;

import vn.iotstart.model.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel FindByUserName(String username);

}
