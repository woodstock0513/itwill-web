package com.itwill.springboot5.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Page<PostListItemDto> read(int pageNo, Sort sort){
		log.info("read(pageNo = {}, sort = {})",pageNo,sort);
		//Pageable 객체 생성
		Pageable p = PageRequest.of(pageNo, 5, sort);
		
		
		//TODO: 영속성 계층의 메서드를 호출해서 엔터티들의 리스트를 가져옴
		//findAll의 아규먼트로 전달
		Page<Post> list = postRepo.findAll(p);
//		log.info("size={}",list.size()); List 였을 떄,, 
		log.info("page.number={}",list.getNumber()); //size 대신 보여줄 현재 페이지 번호
		log.info("page.hasPrevious()={}",list.hasPrevious());
		log.info("page.hasNext()={}",list.hasNext());
		log.info("page.getTotalPages()={}",list.getTotalPages());
		// List<Post> 객체를 List<PostListItemDto> 타입으로 변환\
//		List<PostListItemDto> posts = list.stream().map(PostListItemDto :: fromEntity).toList();
		
//		Page<Post> 객체를 Page<PostListItemDto> 타입으로 변환
		Page<PostListItemDto> posts = list.map(PostListItemDto :: fromEntity);
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
	
	@Transactional(readOnly = true)
	public Post readById(Long id) {
		log.info("readById(id={})",id);
		Post post = postRepo.findById(id).orElseThrow();
		return post;
		
	}
	

}
