package com.itwill.lab05.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.datasource.DataSourceUtil;
import com.itwill.lab05.repository.User.UserBuilder;
import com.zaxxer.hikari.HikariDataSource;

//DAO. data access object 데이터 베이스 crud 담당
public enum UserDao {
	INSTANCE;
	
	private static final Logger log = LoggerFactory.getLogger(UserDao.class);
	private final HikariDataSource ds = DataSourceUtil.getInstance().getDataSource();
	
	// TODO : users 테이블에 insert 하는 sql 문장과 메서드 만들기
	private static final String SQL_INSERT = "insert into users (userid, password, email) values (?, ?, ?)";
	
	public int insert(User user) {
		log.debug("insert {}", user);
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, user.getUserid());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		return result;
	}
	
	//
	private static final String SQL_SIGN_IN = "select * from users where userid = ? and password = ?";
	/**
	 * 로그인 할 때 필요한 메서드
	 * @param user 로그인을 시도한 userid, password를 저장한 객체
	 * @return 데이터베이스의 users 테이블에서 userid와 password가 일치하는 레코드가 있으면
	 * null이 아닌 user타입 객체를 리턴, userid 또는 password가 일치하지 않으면 null을 리턴
	 */
	
	public User selectByUseridAndPassword(User user) {
		log.debug("selectByUseridAndPassword ; {}", user);
		log.debug(SQL_SIGN_IN);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User result = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_SIGN_IN);
			stmt.setString(1, user.getUserid());
			stmt.setString(2, user.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				result = fromResultSetToUser(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return result;
	}
	
	
	
	private User fromResultSetToUser(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String userid = rs.getString("userid");
		String password  = rs.getString("password");
		String email = rs.getString("email");
		int points = rs.getInt("points");
		User user = User.builder().email(email).id(id).userid(userid).password(password).points(points).build();
		return user;
	}




	private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void closeResources(Connection conn, PreparedStatement stmt) {
		closeResources(conn, stmt, null);
	}
	
	
	
	
}
