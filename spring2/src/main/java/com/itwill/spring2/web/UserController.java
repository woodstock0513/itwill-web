package com.itwill.spring2.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring2.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller //일반 컨트롤러! 
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/signup") //get 방식의/user/signup 요청을 처리하는 메서드
	public void signup() {
		 log.debug("GET  signup");
		 
		 //TODO
	}
	
	//사용자 아이디 중복체크 REST 컨트롤러
	@ResponseBody // 메서드 리턴값이 클라이언트로 전달되는 데이터
	@GetMapping("/checkid")
	public ResponseEntity<String> checkId(@RequestParam(name="userid") String userid){
		log.debug("checkId(userid = {}",userid);
		
		boolean result = userService.checkUserid(userid);
		if (result) {
			return ResponseEntity.ok("Y");
		} else {
			return ResponseEntity.ok("N");
		}
		
	}
	
	
	
}
