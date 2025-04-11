package com.vk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vk.dto.Employee;
import com.vk.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {
	
	/*
	 * @GetMapping("/health") public HttpStatus getHealth() { return HttpStatus.OK;
	 * 
	 * }
	 */
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() throws JsonProcessingException{
		List<Employee> employees = service.getEmployees();
		log.info("EmployeeController:getAllEmployees  fetch all employee {} " , new ObjectMapper().writeValueAsString(employees));
		return employees;			
	}

}
