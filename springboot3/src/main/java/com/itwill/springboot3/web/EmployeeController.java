package com.itwill.springboot3.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.domain.Job;
import com.itwill.springboot3.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller @Slf4j
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeService empSvc;
	
	@GetMapping("/list")
	public void employeeList(Model model) {
		log.info("employeeList()");
		List<Employee> list = empSvc.read();
		model.addAttribute("employees", list);
	}
	
	@GetMapping("/details/{id}")
	public String employeeDetails(@PathVariable int id,Model model) {
		log.info("employeeDetails(id = {})",id);
		Employee emp = empSvc.readById(id);
		model.addAttribute("emp", emp);
		return "employee/details";
		
	}
	
	@GetMapping("/job/list")
	public String jobList(Model model) {
		log.info("jobList()");
		List<Job> list = empSvc.readJob();
		model.addAttribute("jobs", list);
		return "job/list";
	}
	
}