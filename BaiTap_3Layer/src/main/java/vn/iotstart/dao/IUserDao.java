package vn.iotstart.dao;

import java.util.List;

import vn.iotstart.model.UserModel;

public interface IUserDao {
    List<UserModel> FindAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel findByUserName(String username);

}
