package com.itwill.springboot5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.springboot5.domain.Post;

//엔터티 클래스 타입, @Id 필드 타입 <,> 안에 각각 적어주기
//extends JpaRepository : CRUD, Paging/Sorting 기본적인 sql과 페이징 처리, 정렬 처리 기능 
public interface PostRepository extends JpaRepository<Post, Long>, PostQuerydsl{
	//JPA 쿼리 메서드 작성
	//제목에 포함된 문자열 대소문자 구분없이 검색하기
	Page<Post> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
	
	//내용에 포함된 문자열 대소문자 구분없이 검색하기
	Page<Post> findByContentContainingIgnoreCase(String keyword, Pageable pageable);
	
	//작성자에 포함된 문자열 대소문자 구분없이 검색하기
	Page<Post> findByAuthorContainingIgnoreCase(String keyword, Pageable pageable);
	
	//이정도는 jpa 이용하는 게 괜찮음
	
	//JPQL(Java Persistence Query Language) : 객체 지향 쿼리 언어
	// 제목 또는 내용에 포함된 문자열 대소문자 구분없이 검색하기 : 메서드이름이,,, 곤란해짐
	//findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(args) : 너무너무길다..
	//findByTitleContainingOrContentContainingAllIgnoreCase(args) : 찔끔 줄인 거. 여전히 길다!
	@Query("select p from Post p "
			+ "where upper(p.title) like upper('%'|| :keyword || '%') "
			+ "or upper(p.content) like upper('%'|| :keyword || '%')") 
	//order By 이런거 필요 없음 어차피 page에서 솔팅 
	Page<Post> findByTitleOrContent(@Param("keyword") String keyword, Pageable pageable);
	

}
