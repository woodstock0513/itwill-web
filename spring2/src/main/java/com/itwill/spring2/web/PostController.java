package com.itwill.spring2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.spring2.dto.PostCreateDto;
import com.itwill.spring2.dto.PostListDto;
import com.itwill.spring2.dto.PostSearchDto;
import com.itwill.spring2.dto.PostUpdateDto;
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
	

    @GetMapping({"/details", "/modify"}) //주소가 여러개인 경우는 배열로!!
    public void details(@RequestParam(name = "id") int id, Model model) {
        log.debug("details(id={})", id);

        Post post = postService.read(id);
        model.addAttribute("post", post);
        
        //리턴 타입이 void 이므로 뷰의 이름은 
        // (1) 요청주소가 /post/details 인 경우 WEB-INF/views/post/details.jsp
        // (2) 요청주소가 /post/modify 인 경우 WEB-INF/views/post/modify.jsp
        
    }
    
    @GetMapping("/create")
    public void create() {
    	log.debug("GET : create()");
    }
    /*
    @PostMapping("/create")
    public String create (@RequestParam(name = "title") String title,
    		@RequestParam(name = "content") String content,
    		@RequestParam(name = "author") String author) {
    	log.debug("POST: create(title={}, content={}, author={})", title, content, author);
    	
    	return "";
    }
    
    이 더러운 코드를 dto 하나로 깔끔하게 만들 수 있음.
    */
    
    @PostMapping("/create")
    public String create (PostCreateDto dto){
    	log.debug("POST: create(dto={})", dto);
    	
    	//서비스 컴포넌트의 메서드를 호출해 데이터베이스에 새 글을 저장.
    	
    	postService.create(dto);
    	return "redirect:/post/list"; //list 페이지로 리다이렉트
    }
    /*
    @GetMapping("/modify")
    public void modify() {
    	log.debug("GET: modify()");
    }
    
    @PostMapping("/modify")
    public String modify(PostCreateDto dto) {
    	log.debug("POST: modify");
    	
    	return "redirect:/post/list";
    }
    일케 새로 안 만들고
    원래 있던 details 메서드 이용,,
    */
    
    
    
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") int id) {
    	log.debug("delete(id={})",id);
    	
    	//컨트롤러는 서비스 컴포넌트의 메서드를 호출해서 db의 테이블에서 해당 아디의 글을 삭제
    	postService.delete(id);
    	
    	//post 목록 페이지로 리다이렉트
    	return "redirect:/post/list";
    
    }
    
    @GetMapping("/update")
    public void update() {
    	log.debug("update()");
    }
    
    
    @PostMapping("/update")
    public String update(PostUpdateDto dto) {
    	log.debug("update()");
    	postService.update(dto);
    	
//    	return "redirect:/post/list";
    	return "redirect:/post/details?id="+Integer.toString(dto.getId());
    }
    

    

}
