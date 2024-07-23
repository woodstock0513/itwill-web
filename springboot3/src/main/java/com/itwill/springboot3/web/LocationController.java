package com.itwill.springboot3.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.domain.Location;
import com.itwill.springboot3.service.LocationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller @Slf4j
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {
	private final LocationService locSvc;
	
	@GetMapping("/list")
	public void locList(Model model) {
		log.info("locList()");
		List<Location> list = locSvc.readLocation();
		model.addAttribute("locations", list);
	}
	
}
