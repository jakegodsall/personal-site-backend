package com.jakegodsall.personalsite.service.impl;

import com.jakegodsall.personalsite.entity.Course;
import com.jakegodsall.personalsite.exceptions.ResourceNotFoundException;
import com.jakegodsall.personalsite.payload.CourseDto;
import com.jakegodsall.personalsite.repository.CourseRepository;
import com.jakegodsall.personalsite.service.CourseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public CourseDto createCourse(CourseDto dto) {
        // Map DTO to entity
        Course course = this.mapToEntity(dto);

        // Set read-only fields
        LocalDateTime currentDate = LocalDateTime.now();
        course.setCreatedDate(currentDate);
        course.setLastModifiedDate(currentDate);

        // Store in the repository
        Course courseInDb = courseRepository.save(course);

        // Map stored entity to DTO and return
        return this.mapToDto(courseInDb);
    }

    @Override
    public CourseDto getCourseById(Long id) {
        // Get the entity from the repository
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course", "id", id)
        );
        // Map to DTO and return
        return this.mapToDto(course);
    }

    @Override
    public CourseDto updateCourseById(CourseDto dto, Long id) {
        // Get the entity from the repository
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course", "id", id)
        );

        // Update the entity
        course.setLastModifiedDate(LocalDateTime.now());
        course.setName(dto.getName());
        course.setAuthor(dto.getAuthor());
        course.setUrl(dto.getUrl());

        // Save the updated entity in the repository
        Course courseInDb = courseRepository.save(course);

        // Map the updated entity to DTO and return
        return this.mapToDto(courseInDb);
    }

    @Override
    public void deleteCourseById(Long id) {
        // Get the entity from the repository
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course", "id", id)
        );

        // Delete the entity
        courseRepository.delete(course);
    }

    private CourseDto mapToDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setLastModifiedDate(course.getLastModifiedDate());
        dto.setCreatedDate(course.getCreatedDate());
        dto.setName(course.getName());
        dto.setAuthor(course.getAuthor());
        dto.setUrl(course.getUrl());
        return dto;
    }

    private Course mapToEntity(CourseDto dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setLastModifiedDate(dto.getLastModifiedDate());
        course.setCreatedDate(dto.getCreatedDate());
        course.setName(dto.getName());
        course.setAuthor(dto.getAuthor());
        course.setUrl(dto.getUrl());
        return course;
    }
}
