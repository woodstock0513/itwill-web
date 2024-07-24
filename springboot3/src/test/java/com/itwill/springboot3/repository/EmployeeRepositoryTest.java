package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	//@Test
	public void testDependencyInjection() {
		assertThat(empRepo).isNotNull();
		log.info("empRepo = {}",empRepo);
//		Repository<T, ID>
//		|__ CrudRepository<T, ID>, PagingAndSortingRepository<T, ID>
//			|__ JpaRepository<T, ID>
//				|__ EmployeeCrudRepository<T, ID>
//					|__ SimpleJpaRepository<T, ID>
	}
	
//	@Test
	public void testFindAll() {
		long count = empRepo.count(); //개수만 알아보기 위한
		assertThat(count).isEqualTo(107L);
		
		List<Employee> list = empRepo.findAll();
		log.info("emp[0] = {}",list.get(0));
	}
	
	@Test
	@Transactional //fetch가 lazy인 경우 필수!!
	public void testFindById() {
		// 1. EmployeeRepository.findById() 메서드 테스트
		// 2. Employees - Jobs 테이블 간의 관계 테스트 (job_id)
		// 3. Employees - Employees 테이블 간의 관계 테스트 (manager_id - employee_id)
		
		// 테이블에 id(사번)가 존재하는 경우:
		Employee emp = empRepo.findById(101).orElseThrow();
		log.info("emp = {}",emp);
		log.info("emp.job = {}", emp.getJob());
		log.info("emp.manager = {}", emp.getManager());
		log.info("emp.department = {}",emp.getDepartment());
		log.info("emp.department.location = {}",emp.getDepartment().getLocation());
		log.info("emp.department.location.country = {}",emp.getDepartment().getLocation().getCountry());
		log.info("emp.department.location.country.region = {}",emp.getDepartment().getLocation().getCountry().getRegion());
	}
}
