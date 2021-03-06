package com.lti.dao.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {
	public static Connection connect() {
		try {
			Properties dbProps = new Properties();
			//dbProps.load(new FileReader("dev-db.properties")); FileNotFoundException
			dbProps.load(ConnManager.class.getClassLoader().getResourceAsStream("prod-db.properties"));
			
			Class.forName(dbProps.getProperty("driverName"));
			//String url = "jdbc:derby://localhost:1527/trainingdb";
			//String user = "bhavya";
			//String pass = "bhavya";
			return DriverManager.getConnection(dbProps.getProperty("url"),dbProps.getProperty("user"),dbProps.getProperty("pass"));
			
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace(); //detailed report of exception
			// we should rather throw user defined exception
			return null;
		}
	}
	/*public static Connection connect() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			String url = "jdbc:derby://localhost:1527/trainingdb";
			String user = "bhavya";
			String pass = "bhavya";
			return DriverManager.getConnection(url, user, pass);
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //detailed report of exception
			// we should rather throw user defined exception
			return null;
		}
	}*/
}
