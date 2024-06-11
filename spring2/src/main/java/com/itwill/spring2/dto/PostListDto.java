package com.itwill.spring2.dto;

import java.time.LocalDateTime;

import com.itwill.spring2.repository.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO
// view와 컨트롤러/컨트롤러와 서비스 사이에서 데이터를 주고받을 때 사용하는 객체 
@Data // @Getter, @Setter, @ToString, @EqualsAndHashcode, @RequiredArgsConstructor 5개
//final 필드가 없으면 @req는 그냥 기본 생성자를 만듦 (이것도 지혼자만 있을 때 @req @noArgs 둘다 있으면 @req가 없는셈?됨)
// 밑의 필드 중에 하나라도 final이 붙으면 그 필드를 아규먼트로 가지는 생성자를 만들고, 기본생성자는 없음.
@NoArgsConstructor @AllArgsConstructor @Builder //빌더는 @AllArgs가 있어야함!!
public class PostListDto {
	private Integer id;
	private String title;
	private String author;
	private LocalDateTime modifiedTime;
	
	//post에서 필요한것만 뽑아내는 메서드
	public static PostListDto fromEntity(Post post) {
		return PostListDto.builder().id(post.getId())
				.author(post.getAuthor()).modifiedTime(post.getModifiedTime())
				.title(post.getTitle()).build();
	}
}
