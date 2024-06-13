package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class) //main에 잇는 스프링 컨테이너를 실행해줌 (작동할 수 잇게)
@ContextConfiguration( //spring이 사용하는 xml 파일을 알려줘야함.
		locations = {"file:src/main/webapp/WEB-INF/application-context.xml"}
)
public class CommentDaoTest {
	
	@Autowired //스프링 컨테이너가 생성하고 관리하는 빈을 주입받음 
	private CommentDao dao;
	//final 쓰면 안되는 이유 : 단위 테스트는 기본 생성자만 부를 수 잇음..
	
	
	@Test
	public void select() {
		Assertions.assertNotNull(dao); //주입받앗는지 확인
		List<Comment> list = dao.selectByPostId(62);
		for (Comment c : list) {
			log.debug(c.toString());
		}
	}
	
//	@Test
	public void insert() {
		Comment comment = Comment.builder().username("admin").ctext("insert JUnitTest").postId(62).build();
		int result = dao.insert(comment);
		Assertions.assertEquals(1, result);
		log.debug(comment.toString());
	}
	
	
	
	
}
