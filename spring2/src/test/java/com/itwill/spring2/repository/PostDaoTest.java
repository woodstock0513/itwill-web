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
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/application-context.xml"})
public class PostDaoTest {

	@Autowired
	private PostDao postDao;
	
//	@Test
	public void testSelectAll() {
		Assertions.assertNotNull(postDao);
		
		List<Post> list = postDao.selectOrderByIdDesc();
				
		for (Post p : list) {
			System.out.println("\t"+p);
		}
		
	}
	
//	@Test
	public void testSelectById() {
		Post post1 = postDao.selectById(31);
		Assertions.assertNotNull(post1);
		log.debug(post1.toString());
		
		Post post2 = postDao.selectById(100);
		Assertions.assertNull(post2);
		
	}
	
	
//	@Test
	public void testInsert() {
		//insert 할 데이터
		Post post = Post.builder().title("my batis").author("test").content("myBatis-Spring").build();
		
		int result = postDao.insertPost(post);
		Assertions.assertEquals(1, result);
		
	}
	
	@Test
	public void testUpdate() {
		Post post = Post.builder().title("update test").content("update").id(62).build();
		int result = postDao.updatePost(post);
		Assertions.assertEquals(1, result);
	}
	
	
//	@Test
	public void testDelete() {
		int result = postDao.deletePost(61);
		Assertions.assertEquals(0, result);
	}
	
}
