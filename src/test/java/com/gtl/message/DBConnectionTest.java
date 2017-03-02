package com.gtl.message;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBConnectionTest {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/webproject";
	private static final String USER = "kskim1";
	private static final String PASS = "1111";
	
	@Test
	public void testConnection() throws ClassNotFoundException{
		
		Class.forName(DRIVER);
		
		// try를 이렇게 묶으면 con.close()가 필요 없다. 알아서 해 줌.
		try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
			System.out.println(con);
		}
		catch(Exception err){
			System.out.println("연결 실패 : " + err);
		}
		finally{
			
		}
	}
}
