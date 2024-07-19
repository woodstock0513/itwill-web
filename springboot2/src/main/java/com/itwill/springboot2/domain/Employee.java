package com.itwill.springboot2.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
//ORM: Object Relation Mapping -> JPA(Java Persistence API) -> Hibernate
@Entity //데이터베이스 테이블과 mapping하는 자바 class(객체)임을 표시
// 문제 : class 이름과 table 이름이 다름 -> 명시해줌
@Table(name = "EMP")
@NoArgsConstructor @Getter @ToString @EqualsAndHashCode //SETTER 없음. 테이블 값을 바꾸지 x. 불변객체로 entity 설계하는 것
public class Employee {
	@Id // Primary Key
	@Column(name="EMPNO") //필드 이름과 실제 컬럼 이름이 다를 때
	private Integer id; //empno
	
	private String ename;
	
	private String job;
	
	@Column(name="MGR")
	private Integer manager; //mgr
	
	private LocalDate hiredate;
	
	@Column(name="SAL")
	private Double salary; //sal
	
	@Column(name="COMM")
	private Double commission; //comm
	
	private Integer deptno;
	
	
	
}
