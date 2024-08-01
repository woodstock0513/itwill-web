package com.itwill.springboot5.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostSearchRequestDto;

//Querydsl 사용:
//1. build.gradle 파일에 의존성과 빌드 옵션을 추가
//2. 프로젝트 이름 오른쪽 클릭 -> gradle -> refresh gradle project
//3. window -> show view -> other... -> gradle task, gradle executions
//4. gradle tasks -> project -> build -> clean 우클릭 -> run gradle task
//5. gradle tasks -> project -> build -> build 우클릭 -> run gradle task
//6. 프로젝트 이름 우클릭 -> gradle -> refresh gradle project
//build/generated/querydsl 폴더에 com.itwill.springboot5.domain 패키지 생성
//패키지에는 Q 클래스들이 자동으로 생성됨
//7. repository에 인터페이스(ex- PostQuerydsl) 작성
//8. 인터페이스를 구현하는 클래스(PostQuerydslImpl)를 작성
// (1) QuerydslRepositorySupport 상속
//		- 상위 클래스가 기본 생성자를 갖고 있지 않기 때문에 명시적으로 아규먼트를 갖는 super를 호출
// (2) PostQuerydsl 인터페이스를 구현
//		- 추상 메서드의 body를 구현
//9. JpaRepository를 상속받는 인터ㅍ이스(PostRepository)에서 PostQuerydsl 인터페이스를 상속.
public interface PostQuerydsl {
	//id가 일치하는 엔터티 검색
	Post searchById(Long id);
	
	//title에 포함된 문자열 대소문자 구분없이 검색
	List<Post> searchByTitle(String keyword);
	//interface는 public abstract 생략

	//content에 포함된 문자열 대소문자 구분없이 검색
	List<Post> searchByContent(String keyword);
	
	//제목 또는 내용에 포함된 문자열 대소문자 구분없이 검색
	List<Post> searchByTitleOrContent(String keyword);
	
	//수정시간 : where modified_time between ? and ?
	List<Post> searchByModifiedTime(LocalDateTime from, LocalDateTime to);
	
	
	//작성자와 제목으로 검색 : where author = ? and lower(title) like ?
	List<Post> searchByAuthorAndTitle(String author, String title);
	
	//제목/내용/제목+내용/작성자 검색
	List<Post> searchByCategory(PostSearchRequestDto dto);
	
	//제목 또는 내용에 검색어들 중 한 개라도 포함되어 있는 레코드들을 검색
	List<Post> searchByKeywords(String[] keywords);
	
	//Paging처리
	Page<Post> searchByKeywords(String[] keywords, Pageable pageable);
	

}

