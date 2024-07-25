package com.itwill.springboot3.dto;

import com.itwill.springboot3.domain.Employee;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Builder @NoArgsConstructor
public class EmployeeListItemDto {
	private Integer employeeId;
	private String employeeName;
	private String phoneNumber;
	private String jobTitle;
	private String departmentName;
	
	public static EmployeeListItemDto fromEntity(Employee emp) {
		//job과 department가 null일 경우 처리하기 위해
		String deptName = (emp.getDepartment() != null) ? emp.getDepartment().getDepartmentName() : null;
		String jobTitle = (emp.getJob() != null) ? emp.getJob().getJobTitle() : null;
		return EmployeeListItemDto.builder().employeeId(emp.getId()).employeeName(emp.getFirstName()+" "+emp.getLastName())
				.phoneNumber(emp.getPhoneNumber()).jobTitle(jobTitle)
				.departmentName(deptName) //nullPointException 방지
				.build();
	}

}