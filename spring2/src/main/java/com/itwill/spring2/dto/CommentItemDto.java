package com.itwill.spring2.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.itwill.spring2.repository.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class CommentItemDto {
	private Integer id;
	private String ctext;
	private String username;
//	private LocalDateTime modifiedTime;
	private Timestamp modifiedTime;
	
	//comment 타입의 객체를 commentItemDto타입 객체로 변환해서 리턴
	public static CommentItemDto fromEntity(Comment comment) {
//		return CommentItemDto.builder().id(comment.getId()).ctext(comment.getCtext())
//				.username(comment.getUsername()).modifiedTime(comment.getModifiedTime()).build();
		
		return CommentItemDto.builder().id(comment.getId()).ctext(comment.getCtext())
				.username(comment.getUsername()).modifiedTime(comment.getModifiedTime()).build();
	}
	

}
