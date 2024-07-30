package com.itwill.springboot5.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostCreateDto;
import com.itwill.springboot5.dto.PostListItemDto;
import com.itwill.springboot5.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j @RequiredArgsConstructor
@Controller @RequestMapping("/post")
public class PostController {
	
	private final PostService postSvc;
	
	@GetMapping("/list")
	public void list(@RequestParam(name = "p", defaultValue = "0") int pageNo, Model model) {
		log.info("list(pageNo = {})",pageNo);
		//TODO: 서비스 계층의 메서드를 호출하여 뷰에 포스트 목록을 전달
		Page<PostListItemDto> list = postSvc.read(pageNo, Sort.by("id").descending());
		model.addAttribute("page", list);
	}
	
	@GetMapping("/create")
	public void create(){
		log.info("GET: create()");
	}

	@PostMapping("/create")
	public String createPost(PostCreateDto dto) {
		log.info("POST : create(dto={})",dto);
		Post post = postSvc.create(dto);
		log.info("Post = {}",post);
		
		return "redirect:/post/list";
	}
}
