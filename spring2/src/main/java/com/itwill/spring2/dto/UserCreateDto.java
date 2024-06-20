package com.itwill.spring2.dto;

import com.itwill.spring2.repository.User;

import lombok.Data;

@Data
// 회원가입 요청 파라미터들을 저장하기 위한 dto
public class UserCreateDto {
	private String userid;
	private String password;
	private String email;
	
	public User toEntity() {
		return User.builder().userid(userid).password(password).email(email).build();
	}
	
}
