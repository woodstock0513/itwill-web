package com.itwill.lab05.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.datasource.DataSourceUtil;
import com.zaxxer.hikari.HikariDataSource;

//MVC 아키텍쳐에서 영속성 계층(repository layer)을 담당하는 클래스
//DB에서 CRUD(create, read, update, delete) 작업을 담당
//DAO(data access object)
public enum PostDao {
	INSTANCE;
	
	private static final Logger log = LoggerFactory.getLogger(PostDao.class);
	private final HikariDataSource ds = DataSourceUtil.getInstance().getDataSource();
	
	private static final String SQL_SELECT_ALL = "select * from posts order by id desc";
	
	public List<Post> select(){ //
		log.debug("select()");
		log.debug(SQL_SELECT_ALL);
		
		List<Post> list = new ArrayList<>(); //SELECT 결과를 저장할 리스트
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Post post = fromResultSetToPost(rs);
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return list;
	}
	
	//post 테이블에 insert하는 sql
	private static final String SQL_INSERT = "insert into posts (title, content, author) values (?, ?, ?)";
	
	public int insert(Post post) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getContent());
			stmt.setString(3, post.getAuthor());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		
		return result;
	}
	
	//post 테이블에서 id(pk)로 행 1개 삭제하기
	private static final String SQL_DELETE = "delete from posts where id = ?";
	
	public int delete(int id) {
		log.debug("delete");
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		
		return result;
	}
	
	//post 테이블에서 id로 검색하는 sql
	private static final String SQL_SELECT_BY_ID = "select * from posts where id = ?";
	
	public Post select(int id) {
		log.debug("select(id={})",id);
		Post post = null;
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				post = fromResultSetToPost(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return post;
	}
	
	
	private Post fromResultSetToPost(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String author = rs.getString("author");
		LocalDateTime createdTime = rs.getTimestamp("created_time").toLocalDateTime();
		LocalDateTime modifiedTime = rs.getTimestamp("modified_time").toLocalDateTime();
		Post post = Post.builder().id(id).title(title).author(author).content(content).modifiedTime(modifiedTime).createdTime(createdTime).build();
		return post;
	}
	
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		//DB 자원들을 해제하는 순서: 생성된 순서의 반대로!!
		try {
			if (rs !=  null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null);
	}
}