package com.vk.util;

import com.vk.dto.CourseRequestDTO;
import com.vk.dto.CourseResponseDTO;
import com.vk.entity.CourseEntity;

public class AppUtils {
    //DTO to entity

    public static CourseEntity mapDTOToEntity(CourseRequestDTO courseRequestDTO){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(courseRequestDTO.getName());
        courseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        courseEntity.setDuration(courseRequestDTO.getDuration());
        courseEntity.setStartDate(courseRequestDTO.getStartDate());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        courseEntity.setEmailId(courseRequestDTO.getEmailId());
        courseEntity.setContact(courseRequestDTO.getContact());
        return courseEntity;



    }

    public static CourseResponseDTO mapEntiyToDTO(CourseEntity courseEntity){
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setCourseId(courseEntity.getCourseId());
        courseResponseDTO.setName(courseEntity.getName());
        courseResponseDTO.setTrainerName(courseEntity.getTrainerName());
        courseResponseDTO.setDuration(courseEntity.getDuration());
        courseResponseDTO.setStartDate(courseEntity.getStartDate());
        courseResponseDTO.setCourseType(courseEntity.getCourseType());
        courseResponseDTO.setFees(courseEntity.getFees());
        courseResponseDTO.setCertificateAvailable(courseEntity.isCertificateAvailable());
        courseResponseDTO.setDescription(courseEntity.getDescription());
        courseResponseDTO.setEmailId(courseEntity.getEmailId());
        courseResponseDTO.setContact(courseEntity.getContact());
        return courseResponseDTO;


    }
}
