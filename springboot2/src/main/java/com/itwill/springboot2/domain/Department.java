package com.itwill.springboot2.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "dept")
@NoArgsConstructor @ToString @Getter
public class Department {
	@Id
	@Column(name = "deptno")
	private Integer id;
	
	@Column(name = "dname")
	private String departmentname;
	
	@Column(name = "loc")
	private String location;
	
	@ToString.Exclude
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
	//mappedBy: employee entity에서 @ManyToOne 애너테이션이 설정된 필드 이름
	private List<Employee> employees;
	

}
