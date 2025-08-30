package vn.iotstart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstart.configs.DBConnectSQLServer;
import vn.iotstart.dao.IUserDao;
import vn.iotstart.model.UserModel;

public class UserDaoImpl extends DBConnectSQLServer implements IUserDao {

	public Connection conn=null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	
	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		UserModel user = userDao.findById(2);
		System.out.println(user);
	}
	
	@Override
	public List<UserModel> FindAll() {
		
		String sql ="SELECT * FROM  [USER]";
		
		List<UserModel> list = new ArrayList<>();
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getString("fullname"),rs.getString("images"),rs.getString("phone"),rs.getInt("roleid"),rs.getDate("createDate")));
			}
			return list;
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserModel findById(int id) {
        String sql ="SELECT * FROM  [USER] WHERE id = ? ";
		
		
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
			
			
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
		
        
		
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public UserModel findByUserName(String username) {
        String sql ="SELECT * FROM  [USER] WHERE username = ? ";
		
		
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
			
			
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
