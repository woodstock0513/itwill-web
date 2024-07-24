package com.itwill.springboot3.repository;

import java.time.LocalDate;
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
//		list=empRepo.findByFirstNameContainingIgnoreCaseOrderByFirstNameDesc("Ev");
//		list = empRepo.findBySalaryGreaterThan(6000);
//		list=empRepo.findBySalaryLessThan(4000);
//		list=empRepo.findBySalaryBetween(2000, 3000);
//		list=empRepo.findByHireDateBefore(LocalDate.of(2003, 1, 5));
//		list=empRepo.findByHireDateAfter(LocalDate.of(2008, 1, 1));
		list = empRepo.findByHireDateBetween(LocalDate.of(2008, 1, 1), LocalDate.of(2008, 5, 1));
		list.forEach(System.out::println);
		
	}
}
