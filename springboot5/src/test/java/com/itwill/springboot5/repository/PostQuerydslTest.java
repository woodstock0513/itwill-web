package com.itwill.springboot5.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostSearchRequestDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostQuerydslTest {
	@Autowired
	private PostRepository postRepo;
	
//	@Test
	public void testSearchById() {
		Post entity = postRepo.searchById(2L);
		log.info("entity={}",entity);
	}
	
	@Test
	public void test() {
		List<Post> result;
//		result = postRepo.searchByTitle("duM");
//		result = postRepo.searchByContent("duM");
//		result = postRepo.searchByTitleOrContent("아");
//		result = postRepo.searchByModifiedTimeLocalDateTime.of(2024, 7, 31, 16, 00), LocalDateTime.now());
//		result = postRepo.searchByAuthorAndTitle("admin", "dum");

//		PostSearchRequestDto dto = new PostSearchRequestDto();
//		dto.setCategory("tc");
//		dto.setKeyword("dum  ");
//		result = postRepo.searchByCategory(dto);
		
		String[] keywords = "아 f".split(" "); //{"아", "f"}; 실제로는 한줄로 나오니가
//		result =postRepo.searchByKeywords(keywords);
		
		Pageable pageable = PageRequest.of(0, 5, Sort.by("id").descending());
		Page<Post> page = postRepo.searchByKeywords(keywords, pageable);
		page.forEach(System.out::println);
//		result.forEach(System.out::println);
//		for (int i = 0; i<5; i++) {
//			log.info("{}",result.get(i));
//		}
		
	}
	
	
}
