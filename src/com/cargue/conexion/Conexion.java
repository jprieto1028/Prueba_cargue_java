package com.cargue.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

	private static BasicDataSource datasource = null;

	private static DataSource getDatasource() {

		if (datasource == null) {
			datasource = new BasicDataSource();
			datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			datasource.setUsername("root");
			datasource.setPassword("1234");
			datasource.setUrl("jdbc:mysql://localhost:3306/prueba");

			datasource.setInitialSize(20);
			datasource.setMaxIdle(15);
			datasource.setMaxTotal(20);
			datasource.setMaxWaitMillis(5000);

		}
		return datasource;
	}

	public static Connection getConnection() throws SQLException {
		
		
		return getDatasource().getConnection();

	}

}
