package com.itwill.spring1.web;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring1.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

// rest 서비스를 하는 컨트롤러 메서드를 작성하는 방법:
// (1) @Controller 클래스에서 @ResponseBody 애너테이션을 선언한 메서드를 작성
// (2) @RestController 클래스의 모든 컨트롤러 메서드. (rest 서비스로 구현됨)
//        -> 컨트롤러가 리턴하는 값은 응답으로 전송되는 data(view의 이름이 아님!!)
@Slf4j
@RestController
public class ExampleRestController {
	
	
	@GetMapping("/rest3")
	public String rest3() {
		log.debug("rest3()");
		
		return "안녕하세요, REST. (rest3)";
	}
	
	
	@GetMapping("/rest4")
	public ArrayList<UserDto> rest4() {
		log.debug("rest4()");
		
		ArrayList<UserDto> list = new ArrayList<>();
		list.add(UserDto.builder().username("young").age(20).build());
		list.add(UserDto.builder().username("kim").age(22).build());
		
		return list;
	}
	
}
