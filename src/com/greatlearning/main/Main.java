package com.greatlearning.main;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Main {


	static JdbcTemplate jdbcTemplateObj;
	static SimpleDriverDataSource dataSourceObj;

	// Db Configuration
	static String USERNAME = "root";
	static String PASSWORD = "290697dani";
	static String URL = "jdbc:mysql://localhost:3306/springjdbc";

	public static SimpleDriverDataSource getDatabaseConnection()  {
		dataSourceObj = new SimpleDriverDataSource();
		try {           
			dataSourceObj.setDriver(new com.mysql.cj.jdbc.Driver());
			dataSourceObj.setUrl(URL);
			dataSourceObj.setUsername(USERNAME);
			dataSourceObj.setPassword(PASSWORD);
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return dataSourceObj;
	}

	public static void main(String[] args) throws SQLException {
		
		// Setting Driver Class Name, Database URL, UserName & Password
		jdbcTemplateObj = new JdbcTemplate(getDatabaseConnection());

		if(null != jdbcTemplateObj) {

			// SQL INSERT Operation
			String sqlInsertQuery = "INSERT INTO Employee (name, email, address, phoneNo) VALUES (?, ?, ?, ?)";
			for(int i=1; i<5; i++) {
				jdbcTemplateObj.update(sqlInsertQuery, "Employee " + i, "Employee" + i +"@gmail.com", "Gurugram", "0123456789");
			}

	
			  // SQL UPDATE Operation 
		    	String sqlUpdateQuery = "UPDATE Employee set email=? where name=?";
			  jdbcTemplateObj.update(sqlUpdateQuery, "admin@greatlearning.com", "Employee 2");
		
	}


}
}
