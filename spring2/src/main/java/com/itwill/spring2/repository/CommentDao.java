package com.itwill.spring2.repository;

import java.util.List;

//mapper.xml 파일과 연결
public interface CommentDao {
	
	// 포스트에 달려있는 모든 댓글 검색
	List<Comment> selectByPostId(Integer postId);
	
	// 포스트에 새로운 댓글 추가
	int insert(Comment comment);

}
