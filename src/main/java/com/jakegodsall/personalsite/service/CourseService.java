package com.jakegodsall.personalsite.service;

import com.jakegodsall.personalsite.payload.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourses();
    CourseDto createCourse(CourseDto dto);
    CourseDto getCourseById(Long id);
    CourseDto updateCourseById(CourseDto dto, Long id);
    void deleteCourseById(Long id);
}
