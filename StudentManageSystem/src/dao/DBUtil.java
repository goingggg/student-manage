package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static final String DRIVER="com.mysql.jdbc.Driver";
	static final String URL="jdbc:mysql://" +
            "localhost:3306/" +
            "users?user=root&" +
            "password=root123&" +
            "verifyServerCertificate=false&useSSL=false";
	static public Connection getConnetcion()throws Exception{
		Class.forName(DRIVER);
		Connection conn=DriverManager.getConnection(URL);
		return conn;
	}


}
