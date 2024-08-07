package com.itwill.springboot5.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@GetMapping("/signin") //SecurityConfig.securityFilterChain 메서드의 formLogin 메서드에서 설정한 요청 주소. formLogin의 아규먼트
	public void signIn() {
		log.info("GET : signIn");
	}
	
	
	//Post Controller 만들 필요가 업금.
//	@PostMapping("/signin")
//	public void postsignIn() {
//		log.info("POST : signIn");
//	}
	
}
