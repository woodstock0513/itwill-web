package com.itwill.spring2.dto;

import com.itwill.spring2.repository.Post;

import lombok.Data;

@Data
public class PostCreateDto {
	//필드 이름을 요청 파라미터 이름과 같게 선언 & 기봉 생겅자랑 setter 필요
	
	private String title;
	private String content ;
	private String author;
	
	public Post toEntity() {
		
		return Post.builder().author(author).title(title).content(content).build();
	}
	
	
}
