package com.itwill.spring2.dto;

import com.itwill.spring2.repository.Comment;
import com.itwill.spring2.repository.CommentDao;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
//댓글 업데이트 요청의 요청 파라미터들을 저장하기 위한 DTO
public class CommentUpdateDto {
	private Integer id;
	private String ctext;
	
	// CommentUpdateDto 타입을 Comment 타입을 변환해서 리턴.
	public Comment toEntity() {
		return Comment.builder().id(id).ctext(ctext).build();
	}
	
}
