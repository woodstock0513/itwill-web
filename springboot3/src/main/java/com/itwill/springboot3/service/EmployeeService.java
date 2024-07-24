package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.domain.Job;
import com.itwill.springboot3.repository.EmployeeRepository;
import com.itwill.springboot3.repository.JobRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository empRepo;
	
	public List<Employee> read(){
		log.info("read()");
		return empRepo.findAll();
	}
	
	public Employee readById(int id) {
		log.info("readById(id={})",id);
		return empRepo.findById(id).orElseThrow();
	}
	
	private final JobRepository jobRepo;
	
	public List<Job> readJob(){
		log.info("readJob()");
		return jobRepo.findAll();
	}
	
	
}