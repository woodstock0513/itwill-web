package com.itwill.springboot2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot2.domain.Department;
import com.itwill.springboot2.domain.Employee;

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
	
	@Transactional
	@Test
	@Order(2)
	public void findAllTest() {
		List<Department> list = deptRepo.findAll();
		assertThat(list.size()).isEqualTo(4);
		log.info("findAll()");
	}
	
	@Transactional
    @Test
    @Order(3)
    public void findByTest() {
        // 부서번호(deptno 컬럼, id 필드)로 검색 테스트
        // 부서번호가 테이블에 있는 경우:
        Department dept1 = deptRepo.findById(10).orElseThrow();
        assertThat(dept1.getId()).isEqualTo(10);
        log.info("dept1: {}", dept1);
        
        //oneToMany 관계 : 10번 부서의 모든 직원 정보 출력
        List<Employee> employees = dept1.getEmployees();
        employees.forEach(System.out::println);
        
        
        // 부서번호가 테이블에 없는 경우:
        boolean isEmpty = deptRepo.findById(100).isEmpty();
        assertThat(isEmpty);
    }

}
