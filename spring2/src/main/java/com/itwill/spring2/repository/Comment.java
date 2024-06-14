package com.itwill.spring2.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
// DB 테이블 comments의 모델
public class Comment {
	private Integer id; //Primary Key
	private Integer postId; // Foreign Key : posts 테이블의 id 컬럼 참조
	private String username; // 댓글 작성자 아이디
	private String ctext; // 댓글 내용
	private LocalDateTime createdTime; // 댓글 최초 작성 시간
//	private LocalDateTime modifiedTime; // 댓글 최종 수정 시간
	private Timestamp modifiedTime;
	
	
	
	
}
