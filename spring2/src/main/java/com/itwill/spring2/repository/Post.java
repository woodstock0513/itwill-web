package com.itwill.spring2.repository;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//MVC 아키텍쳐에서 Model 담당 클래스. 데이터 베이스의 posts 테이블의 구조 표현
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor @Builder //@data 쓰면 그냥 다 한 번에 나옴.
public class Post {
	private Integer id;
	private String title;
	private String content;
	private String author;
	private LocalDateTime createdTime; //실제 컬럼 이름에는 _ 이 사용됨. 필드 이름은 카멜 표기법.
	private LocalDateTime modifiedTime;
	
	
	
	
	
}
