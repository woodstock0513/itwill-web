package com.itwill.springboot5.repository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.domain.Post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest 
public class CommentRepositoryTest {
	//commentRepository의 CRUD 기능 테스트
	
	@Autowired
	private CommentRepository comRepo;
	
//	@Test
	public void test() {
		log.info("test, repo = {}",comRepo);
	}
	
	@Test
	public void saveTest() {
		log.info("save()");
		Post post = Post.builder().id(1L).author("guest").content("집에 가고 싶다 집에 보내줘").title("집에갈래").build();
		Comment com = Comment.builder().ctext("asddasdas").id(1L).post(post).writer("익명").build();
		comRepo.save(com);
	}
	
	@Test
	public void deleteTest() {
		log.info("delete");
		comRepo.deleteById(1L);
	}
	
	@Test
	public void updateTest() {
		log.info("update()");
		
	}
	
}
