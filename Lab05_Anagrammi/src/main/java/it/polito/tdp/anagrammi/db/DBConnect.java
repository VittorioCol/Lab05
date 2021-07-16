package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnect {
	
	static private String jdbcUrl = "jdbc:mysql://localhost/dizionario";
	static private HikariDataSource ds= null;
	
	public static Connection getConnection() {
		if (ds==null){
			HikariConfig config=new HikariConfig();
			config.setJdbcUrl(jdbcUrl);
			config.setUsername("root");
			config.setPassword("");
			
			config.addDataSourceProperty("cachePrepStmts", "true");
			config.addDataSourceProperty("preprStmtChacheSize", "250");
			config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
			ds=new HikariDataSource(config);
		}
		try {
			return ds.getConnection();
		}catch(SQLException e){
			System.err.println("Errore connessione al DB");
			throw new RuntimeException(e);
		}
	}
}
