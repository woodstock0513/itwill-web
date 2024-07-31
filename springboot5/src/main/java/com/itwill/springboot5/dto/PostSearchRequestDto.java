package com.itwill.springboot5.dto;

import lombok.Data;

@Data //기본 생성자 1개를 가짐. -> 타입의 기본값으로 초기화함 -> p=0
public class PostSearchRequestDto  {
	private String category;
	private String keyword;
	private int p; //검색결과 목록의 페이지번호(0부터시작)
}
