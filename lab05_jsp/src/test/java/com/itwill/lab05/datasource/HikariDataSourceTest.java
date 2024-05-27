package com.itwill.lab05.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceTest {
	private static final Logger log = LoggerFactory.getLogger(HikariDataSourceTest.class);
	private final DataSourceUtil util = DataSourceUtil.getInstance();
	
	@Test
	public void test() throws SQLException {
		HikariDataSource ds = util.getDataSource();
		Assertions.assertNotNull(ds); //ds가 null이 아니면 성공
		log.debug("ds = {}",ds); //System.out.ptintf("ds = %s",ds) 같은 느낌
		// 타입 상관없이 다 {}
		
		Connection conn = ds.getConnection(); // 커넥션 풀에서 커넥션 객체를 빌려옴
		Assertions.assertNotNull(conn); //conn이 null이 아니면 성공
		log.debug("conn = {}",conn);
		
		conn.close(); //사용했던 커넥션을 커넥션 풀에 반환
		log.debug("cp closed");
		
	}
}
