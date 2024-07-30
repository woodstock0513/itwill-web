package com.itwill.springboot5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostCreateDto;
import com.itwill.springboot5.dto.PostListItemDto;
import com.itwill.springboot5.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j @RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepo;
	
	@Transactional(readOnly = true) //insert update delete가 아닌 경우 붙이기
	public List<PostListItemDto> read(){
		log.info("read()");
		//TODO: 영속성 계층의 메서드를 호출해서 엔터티들의 리스트를 가져옴
		List<Post> list = postRepo.findAll();
		log.info("size={}",list.size());
		// List<Post> 객체를 List<PostListItemDto> 타입으로 변환\
		List<PostListItemDto> posts = list.stream().map(PostListItemDto :: fromEntity).toList();
		return posts;
		/*
		List<PostListItemDto> postList = new ArrayList<>();
		for (Post p : list) {
			postList.add(PostListItemDto.fromEntity(p));
			System.out.println(postList);
		}
		return postList;
		*/
	}
	
	@Transactional
	public Post create(PostCreateDto dto){
		log.info("create");
		//영속성 계층의 메서드를 호출해서 DB insert 쿼리를 실행
		Post post = postRepo.save(dto.toEntity());
		log.info("entity = {}",post);
		return post;
	}
	
	/*
	@Transactional
	public Long create2(PostCreateDto dto) { //return 타입이 다른 경우
		Long id = postRepo.save(dto.toEntity()).getId();
		return id;
	}
	*/
	

}
