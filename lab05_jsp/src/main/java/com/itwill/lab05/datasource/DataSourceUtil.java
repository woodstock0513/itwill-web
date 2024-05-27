package com.itwill.lab05.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceUtil {
	// singleton
	private static DataSourceUtil instance = null;
	private HikariConfig config;
	private HikariDataSource ds;
	private DataSourceUtil() {
		config = new HikariConfig();  //Hikari CP의 설정(configuration)을 담당하는 객체
		//커넥션 풀(데이터소스) 환경설정 (아래 4가지는 필수)
		config.setDriverClassName("oracle.jdbc.OracleDriver");
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		config.setUsername("jspstudy");
		config.setPassword("jspstudy");
		
		//데이터 소스 객체 생성
		ds = new HikariDataSource(config);
	}
	
	public static DataSourceUtil getInstance() {
		if (instance == null) {
			instance = new DataSourceUtil();
		}
		return instance;
	}
	
	public HikariDataSource getDataSource() {
		return ds;
	}
}
