package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Department;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository deptRepo;
	
//	@Test
	public void test() {
		assertThat(deptRepo).isNotNull();
	}
	
//	@Test
	public void testFind() {
		long count = deptRepo.count();
		assertThat(count).isEqualTo(27);
	}
	
	@Test
	@Transactional
	public void testFindById() {
		Department dept =  deptRepo.findById(10).orElseThrow();
		log.info("dept = {}",dept);
		log.info("dept.location = {}",dept.getLocation());
		log.info("dept.location.country = {}",dept.getLocation().getCountry());
		log.info("dept.location.country.region = {}",dept.getLocation().getCountry().getRegion());
		log.info("dept.manager = {}",dept.getManager());
	}
}
