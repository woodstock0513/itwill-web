package com.itwill.springboot2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot2.domain.Department;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //test여러개여도됨
// 테스트 메서드 순서 지정(방식-OrderAnnotation)
@SpringBootTest
public class DepartmentRepositoryTest {
	
	//TODO: dept 테이블과 매칭되는 엔티티 클래스를 설정, 레포지토리 인터페이스 작성
	// 단위 테스트 클래스 작성
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Test
	@Order(1) //이런식으로 순서 지정
	public void findDepartment() {
		assertThat(deptRepo).isNotNull();
		log.info("deptRepo = {}",deptRepo);
	}
	
	@Test
	@Order(2)
	public void findAllTest() {
		List<Department> list = deptRepo.findAll();
		assertThat(list.size()).isEqualTo(4);
		log.info("findAll()");
	}
	

}
