package com.itwill.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot2.domain.Employee;
import com.itwill.springboot2.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {
	
	//생성자에 의한 의존성 주입. 조건: (1)requiredArgsConstructor + (2) final필드
	private final EmployeeRepository empRepo; 
	
	public List<Employee> read(){
		log.info("read()");
		//영속성(저장소) 계층의 메서드를 호출해서 DB 쿼리를 실행.
		return empRepo.findAll();
	}
	
	public Employee readById(int id) {
		log.info("readById()");
		return empRepo.findById(id).orElseThrow();
		//getById랑 뭐가 다른거지??
	}
	
}
