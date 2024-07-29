package com.itwill.springboot5.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostCreateDto;
import com.itwill.springboot5.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j @RequiredArgsConstructor
@Controller @RequestMapping("/post")
public class PostController {
	
	private final PostService postSvc;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		//TODO: 서비스 계층의 메서드를 호출하여 뷰에 포스트 목록을 전달
		model.addAttribute("list", postSvc.read());
	}
	
	@GetMapping("/create")
	public void create(){
		log.info("create()");
	}

	@PostMapping("/create")
	public String createPost(PostCreateDto dto) {
		log.info("createPost, dto={}",dto);
		Post post = postSvc.create(dto);
		log.info("Post = {}",post);
		
		return "redirect:/post/list";
	}
}
