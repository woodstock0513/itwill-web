package com.itwill.spring2.dto;

import com.itwill.spring2.repository.Comment;
import com.itwill.spring2.repository.CommentDao;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
//댓글을 등록할 때 요청 파라미터로 전달되는 값들을 저장하기 위한 DTO
public class CommentCreateDto {
	private Integer postId;
	private String ctext;
	private String username;
	
	public Comment toEntity() {
		return Comment.builder().postId(postId).ctext(ctext).username(username).build();
	}


}
