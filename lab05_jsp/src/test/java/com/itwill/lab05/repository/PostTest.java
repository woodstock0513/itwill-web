package com.itwill.lab05.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostTest {
	private static final Logger log = LoggerFactory.getLogger(PostTest.class);
	
	private PostDao dao = PostDao.INSTANCE; //싱글턴 객체
	
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
	
//	@Test
	public void testSelect() {
		Assertions.assertNotNull(dao);
		log.debug("dao={}",dao);
		
		List<Post> result = dao.select();
		Assertions.assertEquals(3, result.size());
		for (Post p : result) {
			log.debug(p.toString());
		}
		
//		Assertions.assertNull(result);
	}
	
//	@Test
	public void testInsert() {
		//TODO postdao의 insert 메서드 단위 테스트
		Post post = Post.builder().title("insert").author("guest").content("insert test....").build();
		int result = dao.insert(post);
		Assertions.assertEquals(1, result);
		//insert 메서드의 리턴값이 1이면 성공!
//		log.debug("{}행 삽입",dao.insert(post));
	}
	
//	@Test
	public void testDelete() {
		// TODO postdao의 delete 메서드 단위 테스트
		int result = dao.delete(7);
		Assertions.assertEquals(1, result);
		
		result = dao.delete(2);
		Assertions.assertEquals(0, result);
	}
	
	@Test
	public void testSelectById() {
		Post post = dao.select(1); //id=1(PK)가 테이블에 있는 경우
		Assertions.assertNotNull(post);
		log.debug(post.toString());
	}
	

}
