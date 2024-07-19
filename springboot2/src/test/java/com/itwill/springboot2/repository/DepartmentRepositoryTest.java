package com.itwill.springboot2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DepartmentRepositoryTest {
	
	//TODO: dept 테이블과 매칭되는 엔티티 클래스를 설정, 레포지토리 인터페이스 작성
	// 단위 테스트 클래스 작성
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Test
	public void findDepartment() {
		assertThat(deptRepo).isNotNull();
		log.info("deptRepo = {}",deptRepo);
	}
	
}
