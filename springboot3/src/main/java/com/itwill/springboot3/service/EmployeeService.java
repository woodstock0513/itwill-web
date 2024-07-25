package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true) //읽기전용으로만 사용하고 변경하지 않을 것이다!
	public Page<EmployeeListItemDto> read(int pageNo, Sort sort){
		log.info("read(pageNo={}, sort={})",pageNo,sort);
//		List<Employee> list = empRepo.findAll();
//		return list.stream().map(EmployeeListItemDto::fromEntity)  // (x) -> EmployeeListItemDto.fromEntity(x);
//				.toList();
		
		//Pageable 객체 생성: PageRequest.of(페이지번호, 한 페이지의 아이템 개수, 정렬기준);
		Pageable pageable = PageRequest.of(pageNo, 10, sort);
		
		//findAll(Pageable pageable) 메서드를 호출
		Page<Employee> page = empRepo.findAll(pageable);
		log.info("hasPrevious = {}",page.hasPrevious()); //이전 페이지가 있는 지 여부
		log.info("hasNext = {}",page.hasNext()); //다음 페이지가 있는 지 여부
		log.info("getContent = {}",page.getContent()); //페이지 처리가 끝난 List
		log.info("getTotalPages = {}",page.getTotalPages()); //전체 페이지 개수
		
		//Page<Employee> 타입을 Page<EmployeeListItemDto>로 변환해서 리턴		
		return page.map(EmployeeListItemDto::fromEntity);
	}
	
	@Transactional(readOnly = true)
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
