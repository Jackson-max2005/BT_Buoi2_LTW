package vn.iotstart.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import vn.iotstart.model.UserModel;



public class DBConnectSQLServer {
	private final String serverName="localhost";
	private final String dbName="users";
	private final String portNumber="1433";
	private final String instance ="";
	private final String userID="nguyentanphat";
	private final String password ="123456789";
	
	public Connection getConnection() {
		Connection conn = null;
		
        try {
    		String url = "jdbc:sqlserver://"+serverName+"\\"+instance+":"+portNumber+";databaseName="+dbName;
            if(instance == null || instance.trim().isEmpty()) {
            	url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
            	
            }
            conn = DriverManager.getConnection(url,userID,password); 
            if(conn!= null) {
            	DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
            	System.out.println("Driver name:" + dm.getDriverName());
            	
            	return conn;
            }
            
            
        	
        }catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return null;
		
					
	}
	
	public static void main(String [] args) {
		try {
			System.out.println(new DBConnectSQLServer().getConnection());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	
	
   
	
	

}
