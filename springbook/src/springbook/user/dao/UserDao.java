package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	
	private ConnectionMaker connectionMaker;
	private Connection c;
	private User user;
	
	UserDao(ConnectionMaker connectionMaker){
		this.connectionMaker = connectionMaker;
	}
	
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		this.c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement(
					"insert into users(id,name,password) values(?,?,?) ");
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		
		this.c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement(
		 	"select * from users where id = ? ");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		this.user = new User();
		this.user.setId(rs.getString("id"));
		this.user.setName(rs.getString("name"));
		this.user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
}
