package com.itwill.springboot2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.springboot2.domain.Employee;
import com.itwill.springboot2.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor //-> final 필드를 포기화하는 생성자. 생성자에 의한 의존성 주입 시 사용
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService empSvc;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list()");
		//서비스(비즈니스)계층의 메서드를 호출해서 (데이터베이스의) 직원 목록을 불러옴
		List<Employee> list = empSvc.read();
		
		//직원 목록을 view에게 전달하기 위해 model에 추가
		model.addAttribute("employees", list);
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("empId") int empId, Model model) {
		log.info("detail empId={}",empId);
		Employee emp = empSvc.readById(empId);
		
		model.addAttribute("emp", emp);
		return "employee/detail";
	}
	
}
