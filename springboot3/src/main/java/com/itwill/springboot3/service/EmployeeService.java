package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.domain.Job;
import com.itwill.springboot3.dto.EmployeeListItemDto;
import com.itwill.springboot3.repository.EmployeeRepository;
import com.itwill.springboot3.repository.JobRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository empRepo;
	
	public List<EmployeeListItemDto> read(){
		log.info("read()");
		List<Employee> list = empRepo.findAll();
		return list.stream().map(EmployeeListItemDto::fromEntity)  // (x) -> EmployeeListItemDto.fromEntity(x);
				.toList();
	}
	
	
	public Employee readById(int id) {
		log.info("readById(id={})",id);
		return empRepo.findById(id).orElseThrow();
	}
	
	/*
	public List<Employee> read(){
		log.info("read()");
		return empRepo.findAll();
	}
	
	private final JobRepository jobRepo;
	
	public List<Job> readJob(){
		log.info("readJob()");
		return jobRepo.findAll();
	}
	
	*/
}
