package com.itwill.spring2.repository;

import java.util.List;

//mapper.xml 파일과 연결
public interface CommentDao {
	
	// 포스트에 달려있는 모든 댓글 검색
	List<Comment> selectByPostId(Integer postId);
	
	// 포스트에 새로운 댓글 추가
	int insert(Comment comment);
	
	//댓글 내용, 수정시간 업데이트
	int update(Comment comment);
	
	//댓글 id로 삭제하기
	int deleteById(Integer id);
	
	//포스트에 달려 있는 모든 댓글 삭제
	int deleteByPostId(Integer postId);
	
	//포스트에 달려있는 댓글 개수를 검색
	int selectCommentCount(Integer postId);
	
	//댓글 아이디(pk)로 검색
	Comment selectById(Integer id);

}
