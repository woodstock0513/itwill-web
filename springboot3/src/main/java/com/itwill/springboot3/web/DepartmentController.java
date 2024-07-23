package com.itwill.springboot3.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.repository.DepartmentRepository;
import com.itwill.springboot3.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller @Slf4j
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

	private final DepartmentService deptSvc;
	
	@GetMapping("/list")
	public void departmentList(Model model) {
		log.info("departmentList()");
		List<Department> list = deptSvc.read();
		model.addAttribute("departments", list);
	}
	
	@GetMapping("details/{id}")
	public String departmentDetail(@PathVariable int id, Model model) {
		log.info("departmentDetails(id={})",id);
		Department dept = deptSvc.readById(id);
		model.addAttribute("dept", dept);
		return "department/details";
	}
	
}
