package com.itwill.springboot3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "departments")
@Getter @ToString @EqualsAndHashCode @NoArgsConstructor
public class Department {
	
	@Id @Column(name = "department_id")
	private Integer id;
	
	private String departmentName;
	
	private Integer locationId;
 
	
	@ToString.Exclude
	@OneToOne(fetch = FetchType.LAZY) //lazy 오류나서 eager로 바꿈
	@JoinColumn(name = "manager_id")
	private Employee manager;
	
}
