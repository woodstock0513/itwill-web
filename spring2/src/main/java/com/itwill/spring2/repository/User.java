package com.itwill.spring2.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//데이터베이스 테이블 users 테이블의 모델 객체
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class User {
	private Integer id; //pk
	private String userid;
	private String password;
	private String email;
	private Integer points;
}
