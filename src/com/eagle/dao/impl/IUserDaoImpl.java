package com.eagle.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.eagle.dao.IUserDao;
import com.eagle.service.bean.User;

public class IUserDaoImpl implements IUserDao{
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String username="king";
	private String password = "king999";
	private Connection conn = null;
	int i=0;
//	private PreparedStatement ps = null;

	public void saveUser(User user) throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql="insert into t_user(id,name,password,age) values(?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		long id=user.getId();
		String uName=user.getName();
		String password=user.getPassword();
		int age = user.getAge();
	
		ps.setLong(1, id);
		ps.setString(2, uName);
		ps.setString(3, password);
		ps.setInt(4, age);
		
		
//			i++;
//			if(i==100){
//				ps.executeBatch();
//				i=0;
//			}
			ps.executeBatch();
			
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		
		
	}

	public User findUserByName(String name) throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt=conn.createStatement();
		String sql="select * from t_user where name='"+name+"'";
		
		ResultSet rs=stmt.executeQuery(sql);
		
		User u=null;
		while(rs.next()){
			
			long id=rs.getLong("id");
			String uName=rs.getString("name");
			String password=rs.getString("password");
			int age = rs.getInt("age");
			
			u.setId(id);
			u.setName(uName);
			u.setPassword(password);
			u.setAge(age);
			
		}
		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
		
		return u;
	}

}
