package com.itwill.springboot5.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostCreateDto;
import com.itwill.springboot5.dto.PostListItemDto;
import com.itwill.springboot5.dto.PostSearchRequestDto;
import com.itwill.springboot5.dto.PostUpdateDto;
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
		
		//pagination fragment에서 사용하기 위한 현재 요청 주소 정보
		model.addAttribute("baseUrl", "/post/list");
		
		
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
	
	@GetMapping({"/details","/modify"})
	public void details(@RequestParam(name = "id") Long id, Model model) {
		log.info("details(id={})",id);
		Post post = postSvc.readById(id);
		model.addAttribute("post", post);
		
		//-> view의 이름은 요청주소에 따라 정해짐
		//details -> details.html  modify-> modify.html임!
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") Long id) {
		log.info("delete(id={})",id);
		postSvc.delete(id);
		return "redirect:/post/list";
	}
	
	@PostMapping("/update")
	public String update(PostUpdateDto dto) {
		log.info("update(dto={})",dto);
		postSvc.update(dto);
		return "redirect:/post/details?id="+dto.getId();
	}
	
	@GetMapping("/search")
	public String search(PostSearchRequestDto dto, Model model) {
		log.info("search(dto={})",dto);
		
		//TODO
		Page<PostListItemDto> posts = postSvc.search(dto, Sort.by("id").descending());
		model.addAttribute("page", posts);
		
		//pagination fragment에서 사용할 현재 요청 주소 정보
		model.addAttribute("baseUrl", "/post/search");
		
		
		return "post/list";
	}
	
	
}
