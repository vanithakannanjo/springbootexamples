package com.vk.controller;

import com.vk.dto.CourseRequestDTO;
import com.vk.dto.CourseResponseDTO;
import com.vk.dto.ServiceResponse;
import com.vk.service.FacultyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculty-service")
public class FacultyController {
    @Autowired
    private FacultyService service;
    @PostMapping("/addNewCourse")
    public ServiceResponse<CourseResponseDTO> addNewCourse(@RequestBody CourseRequestDTO courseRequestDTO){
        return service.addNewCourseToDashboard(courseRequestDTO);
    }

    @GetMapping("/allCourses")
    public ServiceResponse<List<CourseResponseDTO>> fetchAllCourses(){
    	return service.fetchAllCourses();
    }
    
    @GetMapping("/getCourse/{courseId}")
    public ServiceResponse<CourseResponseDTO> getCourseById(@PathVariable int courseId){
    	return service.findCourseById(courseId);
    }
    
    @GetMapping("/getCourse/request")
    public ServiceResponse<CourseResponseDTO> getCourseByIdRequestParam(@RequestParam int courseId){
    	return service.findCourseById(courseId);
    }
    
    @PutMapping("/updateCourse/{courseId}")
    public ServiceResponse<CourseResponseDTO> updateCourse(@PathVariable int courseId, @RequestBody CourseRequestDTO courseRequestDTO){    	
    	service.updateCourseInDashBoard(courseId, courseRequestDTO);
    	return service.findCourseById(courseId);
    }
    
   
    @DeleteMapping("/deleteCourse/{courseId}")
    public String deleteCourse(@PathVariable int courseId){
    	service.deleteCourseFromDashboard(courseId);
    	return "Course successfully deleted with id " + courseId;
    }
    
}
