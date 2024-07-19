package com.itwill.springboot2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "dept")
@NoArgsConstructor @ToString
public class Department {
	@Id
	private Integer deptno;
	
	@Column(name = "dname")
	private String departmentname;
	
	@Column(name = "loc")
	private String location;

}
