package com.itwill.spring1.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring1.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

//POCO(Plain Old C++ Object)
//POJO(Plain Old Java Object): 
// 특정 클래스를 상속(extends)하거나 특정 인터페이스를 구현(implements)할 필요가 없는 
// (상위 타입의 특정 메서드들을 반드시 재정의할 필요가 없는) 평범한 자바 객체
// 스프링 MVC 프레임워크에서는 POJO로 작성된 클래스를 컨트롤러로 사용할 수 있음
// (비교) HttpServlet 을 상속받는 클래스에서는 doGet(req,resp) 또는 doPost(req,resp)를
// 반드시 재정의(override)해야 웹서비스(요청처리)가 가능!!!

@Slf4j  //-> private static final Logger log = LoggerFactory.getLogger(ExampleController.class); 코드를 알아서 삽입해줌!
@Controller //dispatcher servlet에게 컨트롤러 컴포넌트임을 알려줌
// (1) servelt-context.xml에서 <context:component-scan base-package="com.itwill.spring1.web" /> 설정하고
// (2) 컨트롤러 클래스에서는 @Controller 애너테이션을 사용해야함
// -> 디스패쳐 서블릿이 컨트롤러 객체를 생성, 관리 가능
//패키지를 여러개에 저장할 경우, component-scan을 더 써주면 됨!
public class ExampleController {
	
	@GetMapping("/") 
	public String home(Model model) {
		log.debug("home()");
		
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("now", now);
		//model 객체는 컨트롤러에서 뷰로 데이터를 전달할 때 사용
		// requset.setAttribute(name, object)랑 비슷한 기능
		
		return "home"; //jsp 파일 이름!!!을 리턴!!
		// controller 메서드가 문자열을 리턴하면, dispatcher servlet이 뷰의 이름을 찾는 데 사용
		// 디스패쳐 서블릿이 뷰 리졸버를 이용해서 /WEB-INF/views/returnValue.jsp 경로를 찾을 수 있다
		// sevlet-context.xml 설정에서 접두사/접미사 설정을 했기 때문에 저 경로를 찾을 수 있는 것
	}
	
	@GetMapping("/example")
	public void controllerExample() {
		log.debug("controllerExample()");
		//컨트롤러 메서드가 리턴값이 없는 경우
		// 요청 주소가 view의 이름이 됨!!
	}
	
	@GetMapping("/ex1")
	public void example1(@RequestParam(name = "username") String username,
						@RequestParam(name = "age", defaultValue = "0") int age,
						Model model) {
		log.info("example1(username={},age={})",username, age);
		// 컨트롤러 메서드 파라미터를 선언할 때 @RequestParam 애너테이션을 사용하면
		//디스패쳐 서블릿이 컨트롤러 메서드를 호출할 때, 
		// (1) request.getParameter("username"), request.getParameter("age")를 호출해서 요청 파라미터 값들을 읽고
		// (2) 컨트롤러 메서드의 아규먼트로 전달해줌
		
		//요청파라미터 값들로 UserDto 객체를 생성
		UserDto user= UserDto.builder().username(username).age(age).build();
		
		// UserDto 객체를 뷰로 전달 -> 모델 이용
		model.addAttribute("user", user);
	}
	
	@PostMapping("/ex2")
	public String ex2(@RequestParam(name = "user") UserDto dto) {
		log.debug("ex2(dto={})", dto);
		//-> @ModelAttribute(name="user") UserDto user 파라미터 선언은
		// model.addAttribute("user", dto); 코드 작성과 같은 효과
		// 컨트롤러에서 뷰로 전달하는 데이터
		
		return "ex1"; //-> view 이름
	}
	
	
	@GetMapping("/test")
	public void test() {
		log.debug("test");
	}
	
	@GetMapping("/test2")
	public String forward() {
		log.debug("forward");
		
		return "forward:/test"; //접두사
		//컨트롤러 메서드가 foward:로 시작하는 문자열을 리턴
		//test로 포워드 하라는 뜻
	}
	
	@GetMapping("/test3")
	public String redirect() {
		log.debug("redirect");
		
		return "redirect:/test";
	}
	
	@ResponseBody
	//-> 컨트로러 메서드가 리턴하는 값이 뷰를 찾기 위한 문자열이 아니라
	// 클라이언트로 직접 응답되는 데이터.
	// 응답패킷(response packet)의 몸통에 포함되는 데이터
	@GetMapping("/rest1")
	public String rest1() {
		log.debug("rest1()");
		return "Hello~";
	}
	
	@ResponseBody // -> 리턴값이 클라이언트로 직접 응답되는 객체
	@GetMapping("/rest2")
	public UserDto rest2() {
		log.debug("rest2()");
		
		return UserDto.builder().username("moon").age(23).build();
		// rest 컨트롤러가 리턴한 자바 객체를 jackson-databind 라이브러리에서
		// JSON(JavaScript Object Notation) 형식의 문자열로 변환하고
		// 클라이언트로 응답을 보냄. (뷰를 거치지 않고 바로 클라이언트로 감)
		// pom.xml에 jackson-databind가 꼭!!! 있어야함
	}
	
	
	
}
