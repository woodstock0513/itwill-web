package com.itwill.springboot3.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	List<Employee> findByHireDateLessThan(LocalDate date);
	
	
	//입사날짜가 특정 날짜 이후인 직원들의 정보 (where hiredate > ?)
	List<Employee> findByHireDateAfter(LocalDate date);
	List<Employee> findByHireDateGreaterThan(LocalDate date); //크다. 이므로 포함 안됨
	
	//입사날짜가 날짜 범위 안에 있는 직원들의 정보 (where hiredate between ?1 and ?2)
	List<Employee> findByHireDateBetween(LocalDate date1,LocalDate date2);
	
	//부서 이름으로 직원 검색
	List<Employee> findByDepartmentDepartmentName(String name);
	
	//근무하는 도시 이름으로 직원 검색
	List<Employee> findByDepartmentLocationCity(String city);
	
	//대소문자 구분없이 성 또는 이름에 문자열이 포함된 직원 찾기
	List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
	//메서드 이름이 너무너무 길어!!!!!!
	
	// JPQL(Java Persistence Query Language)
	// JPA에서 사용하는 "객체지향(object-oriented)" 쿼리 문법
	// 테이블 이름과 테이블의 컬럼 이름으로 쿼리 문장을 작성하는 것이 아니라,
	// entity 객체 이름과 엔터티 필드 이름으로 쿼리를 작성하는 문법
	// alias(별명)을 반드시 사용해야 함.
	// 엔터티 이름과 필드 이름은 대소문자를 구분함!	
	
	@Query("select e from Employee e "
			+ "where upper(e.firstName) like upper('%'||?1||'%') "
			+ "or upper(e.lastName) like upper('%'||?2||'%')")
	List<Employee> findByname(String firstName, String lastName);
	
	/*
	@Query("select e from Employee e where upper(e.firstName) like upper('%'|| :first || '%') "
			+ "or upper(e.lastName) like upper('%'|| :last || '%')")
	List<Employee> findByName2(@Param("first") String firstName, @Param("last") String lastName);
	*/
	
	//1개를 검색할거면 그냥 keyword로 합치면 됨
	@Query("select e from Employee e where upper(e.firstName) like upper('%'|| :keyword || '%') "
			+ "or upper(e.lastName) like upper('%'|| :keyword || '%')")
	List<Employee> findByName2(@Param("keyword") String keyword);
	
	//부서 이름으로 검색하기
	@Query("select e from Employee e where e.department.departmentName = :dname") //join을 쓸 필요없음! 이게 바로 객체지향쿼리!!
	List<Employee> findByDeptName(@Param("dname") String deptName);
	
	//특정 도시에 근무하는 직원들 검색
	@Query("select e from Employee e where e.department.location.city = :city")
	List<Employee> findByCity(@Param("city") String city);
	
	//특정 국가에 근무하는 직원들 검색
	@Query("select e from Employee e where e.department.location.country.countryName = :ctry")
	List<Employee> findByCountry(@Param("ctry") String country);
	
}
