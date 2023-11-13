package com.jakegodsall.personalsite.controller;

import com.jakegodsall.personalsite.entity.Course;
import com.jakegodsall.personalsite.payload.CourseDto;
import com.jakegodsall.personalsite.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CourseController {
    private static final String PATH_V1_COURSE = "/api/v1/courses";
    private static final String PATH_V1_COURSE_ID = PATH_V1_COURSE + "/{courseId}";
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(PATH_V1_COURSE)
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping(PATH_V1_COURSE)
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        CourseDto course = courseService.createCourse(courseDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course.getId())
                .toUri();
        return ResponseEntity.created(location).body(course);
    }

    @GetMapping(PATH_V1_COURSE_ID)
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId) {
        CourseDto course = courseService.getCourseById(courseId).get();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PutMapping(PATH_V1_COURSE_ID)
    public ResponseEntity<CourseDto> updateCourseById(
            @RequestBody CourseDto courseDto,
            @PathVariable Long courseId
    ) {
        CourseDto dto = courseService.updateCourseById(courseDto, courseId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(PATH_V1_COURSE_ID)
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long courseId) {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }
}
