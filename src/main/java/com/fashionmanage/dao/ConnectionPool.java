package com.fashionmanage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	private ConnectionPool() {
		// private constructor
	}

	/**
	 * Connection instance
	 */
	private Connection connection = getConnection();

	private static ConnectionPool instance = null;

	public static ConnectionPool getInstance() {
		if (instance == null)
			instance = new ConnectionPool();
		return instance;
	}

	/**
	 * Getting connection from connection pool.
	 *
	 * @see ConnectionPool
	 * @throws SQLException
	 */
	Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String username = "epflftglcmrosn";
		String password = "e5a246ce4c39804cb532a39a36adb9a82715cd3b39f4644fb3aa954c8456c756";
		String dbUrl = "jdbc:postgresql://" + "ec2-54-246-89-234.eu-west-1.compute.amazonaws.com:5432"
				+ "/d3kvb6ncf4e8f?sslmode=require";
		try {
			return DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
