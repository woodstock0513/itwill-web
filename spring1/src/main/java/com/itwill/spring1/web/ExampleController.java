package com.itwill.spring1.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	
}
