package com.itwill.springboot3.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor @Getter @ToString @EqualsAndHashCode
@Entity @Table(name = "employees") //employees table에 매핑되는 entity
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	private Integer id;
	
	//JPA는 카멜 표기법으로 작성된 엔터티 필드 이름을 테이블 컬럼의 스네이크 표기법의 컬럼 이름으로 자동 매핑함.
	//필드: firstName <---> 컬럼이름: first_name
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	private LocalDate hireDate;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id")
	private Job job;
//	private String jobId;
	
	private Double salary;
	
	private Double commissionPct;
	
	// self join
//	private Integer managerId;
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	private Employee manager;
	//관계를 맺엇으니 in대신에emp
	
	
//	private Integer departmentId;
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;
	
}
