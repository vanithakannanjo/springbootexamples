package com.vk.service;

import com.vk.dto.CourseRequestDTO;
import com.vk.dto.CourseResponseDTO;
import com.vk.dto.ServiceResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FacultyService {

    private final static String BASE_URL="http://localhost:8094/";
    @Autowired
    private RestTemplate restTemplate;

    public ServiceResponse<CourseResponseDTO> addNewCourseToDashboard(CourseRequestDTO courseRequestDTO) {
        return restTemplate.postForObject(BASE_URL + "course", courseRequestDTO, ServiceResponse.class);
    }
    
    public ServiceResponse<List<CourseResponseDTO>> fetchAllCourses(){
    	return restTemplate.getForObject(BASE_URL + "course",  ServiceResponse.class);    	
    }
    
    
    public ServiceResponse<CourseResponseDTO> findCourseById(int courseId){
    	//return restTemplate.getForObject(BASE_URL + "course/search/path/", ServiceResponse.class,courseId);
    	return restTemplate.getForObject("http://localhost:8094/course/search/path/"+ courseId, ServiceResponse.class,courseId);
    }
    
    public ServiceResponse<CourseResponseDTO> findCourseByIdUsingRequestParam(int courseId){
    	Map<String,Integer> requestMap =new HashMap<>();
    	requestMap.put("courseId", courseId);
    	return restTemplate.getForObject(BASE_URL + "course/search/request?courseId={courseId}", ServiceResponse.class,requestMap);
    }

    public void  updateCourseInDashBoard(int courseId, CourseRequestDTO courseRequestDTO){
    	restTemplate.put(BASE_URL + "course/" + courseId, courseRequestDTO);
    	
    }
    
    public void deleteCourseFromDashboard(int courseId) {
    	restTemplate.delete(BASE_URL + "course/" + courseId);
    }

}
