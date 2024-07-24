package com.itwill.springboot3.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot3.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//JPA query method 작성 방법: 이름만 잘 만들어주면 됨!!!!
	//JPA에서 약속된 키워드들과 엔터티의 필드 이름들을 사용해서
	//메서드 이름(camel 표기법) 작성 시 이용
	
	// select * from employees where department_id = ?
	List<Employee> findByDepartmentId(Integer id);
	
	//이름으로 검색
	//select * from employees where first_name=?
	List<Employee> findByFirstName(String firstName);
	
	//이름에 포함된 단어로 검색
	//select * from employees where first_name like '%?%'
	List<Employee> findByFirstNameContaining(String keyword); //- containing도 됨!
	//-> containing: 아규먼트에 '%'를 사용할 필요가 없음
	
	List<Employee> findByFirstNameLike(String keyword);
	//->like: 아규먼트에 '%'(여러글자) 또는 '_'(한글자) 를 사용해야함
	
	//이름에 포함된 단어로 검색, 단어의 대/소문자 구분 없이 검색.
	//select * from employees where upper(first_name) = upper(?)
	List<Employee> findByFirstNameContainingIgnoreCase(String keyword);
	
	//이름에 포함된 단어로 검색, 단어의 대/소문자 구분 없이 검색, 정렬순서는 이름 내림차순
	//select * from employees where upper(first_name) = upper(?) order by first_name desc
	List<Employee> findByFirstNameContainingIgnoreCaseOrderByFirstNameDesc(String keyword);	
	
	//급여가 어떤 값을 초과하는 직원들의 정보
	//select * from employees where salary > ?
	List<Employee> findBySalaryGreaterThan(Integer salary);
	
	//급여가 어떤 값 미만인 직원들의 정보(where salary < ?)
	List<Employee> findBySalaryLessThan(Integer salary);
	
	//급여가 어떤 범위 안에 있는 직원들의 정보 (where salary between ?1 and ?2)
	List<Employee> findBySalaryBetween(Integer minSalary, Integer maxSalary);
	
	//입사날짜가 특정 날짜 이전인 직원들의 정보 (where hiredate < ?)
	List<Employee> findByHireDateBefore(LocalDate date);
	
	//입사날짜가 특정 날짜 이후인 직원들의 정보 (where hiredate > ?)
	List<Employee> findByHireDateAfter(LocalDate date);
	
	//입사날짜가 날짜 범위 안에 있는 직원들의 정보 (where hiredate between ?1 and ?2)
	List<Employee> findByHireDateBetween(LocalDate date1,LocalDate date2);
	
}
