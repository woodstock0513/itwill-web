package com.itwill.springboot2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.springboot2.domain.Department;
import com.itwill.springboot2.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j @RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
	
	private final DepartmentService deptSvc;
	
	@GetMapping("/list")
	public void readDepartment(Model model) {
		log.info("readDepartment()");
		List<Department> list = deptSvc.read();
		
		log.info("list = {}",list);
		model.addAttribute("departments", list);
	}
	
	@GetMapping("/detail")
	public void readById(@RequestParam("deptId") int deptId, Model model) {
		log.info("department detail, deptId = {}",deptId);
		
		Department dept = deptSvc.readById(deptId);
		model.addAttribute("dept", dept);
	}
}
