package com.itwill.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
// -> @Getter, @Setter, @EqualsAndHashCode, @ToString, @RequiredArgsConstructor 을 만들어줌!
@Builder @AllArgsConstructor //모든 필드가 들어있는 생성자	
@NoArgsConstructor //기본 생성자
public class UserDto {
	private String username;
	private int age;
}
