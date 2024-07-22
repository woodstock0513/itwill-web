package com.itwill.springboot2.repository;

//import static 구문: static 메세드, 필드 이름을 import
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;
import java.util.Optional;

//import org.junit.jupiter.api.Assertions; 기존 방식
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot2.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {
	@Autowired //의존성 주입 (DI), 제어의 역전(IoC, Inversion of Control)
	private EmployeeRepository empRepo;
	
	//@Test
	public void test() {
		///Assertions.assertNotNull(empRepo); //기존에 쓰던 방식
		assertThat(empRepo).isNotNull(); //새로운 방식
		//empRepo 객체가 null이 아니면 테스트 성공
		log.info("empRepo = {}",empRepo);
	}
	
	//select * from emp
	//@Test
	public void findAllTest() {
		List<Employee> list = empRepo.findAll();
		assertThat(list.size()).isEqualTo(14);
		for (Employee e : list) {
			System.out.println(e); //table 값들이 나옴
		}
	}
	
	//TODO : 사번으로 검색하는 메서드를 찾아서 단위 테스트 코드 작성
	//@Test
	@Transactional
	public void findByEmpnoTest() {
		Optional<Employee> emp = empRepo.findById(7499);
		//assertThat(emp).isNotNull();
		//Employee allen =  emp.get(); //emp가 null이면 get 호출시 예외 발생
		Employee allen = emp.orElseGet(()->null);
		assertThat(allen).isNotNull();
		assertThat(allen.getEname()).isEqualTo("ALLEN");
		log.info("allen = {}",allen);
		log.info("dept = {}",allen.getDepartment());

		//사번이 테이블에 없는 경우
		Optional<Employee> emp2 = empRepo.findById(1000);
		Employee none = emp2.orElseGet(()->null);
		// orElseGet: 값이 있으면 리턴, 그렇지 않으면 메서드 실행 후 결과값 리턴. 
		assertThat(none).isNull();
	}
	
	@Transactional
	@Test
	public void findMannagerTest() {
		//사번이 7369인 직원 정보 검색
		//Optional<Employee> emp = empRepo.findById(7369);
		Employee emp = empRepo.findById(7369).orElseThrow();
		assertThat(emp.getId()).isEqualTo(7369);
		log.info("emp = {}",emp);
		
		Employee mgr = emp.getManager();
		assertThat(mgr.getId()).isEqualTo(7902);
		log.info("mgr = {}",mgr);
	}
}
