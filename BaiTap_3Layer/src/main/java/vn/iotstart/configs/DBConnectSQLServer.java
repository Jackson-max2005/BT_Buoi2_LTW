package vn.iotstart.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQLServer {
	private final String serverName="localhost";
	private final String dbName="users";
	private final String portNumber="1433";
	private final String instance ="";
	private final String userID="nguyentanphat";
	private final String password ="123456789";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:sqlserver://"+serverName+"\\"+instance+":"+portNumber+";databaseName="+dbName;
        if(instance == null || instance.trim().isEmpty()) {
        	url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
        	
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        return DriverManager.getConnection(url, userID, password);
		
					
	}
	
	public static void main(String [] args) {
		try {
			System.out.println(new DBConnectSQLServer().getConnection());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
	
	


