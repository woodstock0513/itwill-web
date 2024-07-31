package com.itwill.springboot5.repository;

import com.itwill.springboot5.domain.Post;

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
	Post searchById(Long id);
}
