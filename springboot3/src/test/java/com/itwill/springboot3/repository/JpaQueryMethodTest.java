package com.itwill.springboot3.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JpaQueryMethodTest {
	@Autowired
	private EmployeeRepository empRepo;
	
	@Test
	public void test() {
		List<Employee> list;
		
//		list = empRepo.findByDepartmentId(30);
//		list = empRepo.findByFirstName("Steven");
//		list = empRepo.findByFirstNameContaining("ev"); 
//		list = empRepo.findByFirstNameLike("%ev%");
//		list=empRepo.findByFirstNameContainingIgnoreCase("eV");
		list=empRepo.findByFirstNameContainingIgnoreCaseOrderByFirstNameDesc("Ev");

		list.forEach(System.out::println);
		
	}
}
