package com.itwill.lab05.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostTest {
	private static final Logger log = LoggerFactory.getLogger(PostTest.class);
	
	private PostDao dao = PostDao.INSTANCE;
	
	//JUnit 모듈에서 단위 테스트를 하기 위해서 호출하는 메서드
	// (1) public void (2) 아규먼트를 갖기 않음
//	@Test //test 애너테이션만 지우면 JUnit 모듈은 실행하지 않음
	public void test() {
		//Post 타입 객체 생성 - builder 디자인 패턴
		Post p = Post.builder().title("test!").author("admin").content("builder design pattern").id(1).build();
		
		//assertnotNull(arg): arg가 null이면 JUnit 테스트 실패, not null이면 성공
		//assertNull(arg): arg가 null이면 JUnit 테스트 성공, not null이면 실패
		Assertions.assertNotNull(p);
		log.debug("p={}",p);
	}
	
	@Test
	public void testPostDao() {
		Assertions.assertNotNull(dao);
		log.debug("dao={}",dao);
		List<Post> result =dao.select();
		Assertions.assertNull(result);
	}
	
	

}
