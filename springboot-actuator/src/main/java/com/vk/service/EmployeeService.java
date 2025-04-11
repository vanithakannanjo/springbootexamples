package com.vk.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vk.dto.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	
	public List<Employee> getEmployees() throws JsonProcessingException{		
		 
				List<Employee> employees = IntStream.rangeClosed(1, 10).mapToObj(i->new Employee(i,"Employee"+i)).collect(Collectors.toList());
				log.info("EmployeeService :: getEmployees() " , new ObjectMapper().writeValueAsString(employees));				
				return employees;
		
	}
}
