package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class CountConnectionMaker implements ConnectionMaker{
	
	int counter = 0;
	private ConnectionMaker realconnectionMaker;
	
	public CountConnectionMaker() {
		this.realconnectionMaker = realconnectionMaker;
	}
	
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		this.counter++;
		return realconnectionMaker.makeConnection();
	}
	
	public int getCounter(){
		return this.counter;
	}

}
