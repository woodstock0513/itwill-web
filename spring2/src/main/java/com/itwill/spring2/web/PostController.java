package com.itwill.spring2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.spring2.dto.PostListDto;
import com.itwill.spring2.repository.Post;
import com.itwill.spring2.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller//필수
@RequestMapping("/post")
@RequiredArgsConstructor //final 필드들을 초기화하는 생성자.
//PostController 클래스의 모든 컨트롤러 메서드의 매핑 주소는 post로 시작.
public class PostController {
	
	private final PostService postService; // 생성자에 의한 의존성 주입
	
	@GetMapping("/list") //"/post"를 안 써도 됨. req가 없으면 다 써야함.
	public void list(Model model) {
		//void인 경우 view 찾는 법..
		//WEB-INF/views/post/list.jsp (주소에 접두사, 접미사 다 붙이면~ 
		//post(상위 요청주소)는 폴더, list(하위요청주소)는 파일이름
		log.debug("list()");
		//서비스 컴포넌트의 메서드를 호출, 포스트 목록을 읽어옴 -> 뷰에 전달
		List<PostListDto> list = postService.read();
		model.addAttribute("posts", list);
		
		
		
		
	}

}
