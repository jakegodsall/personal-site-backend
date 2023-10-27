package com.jakegodsall.personalsite.repository;

import com.jakegodsall.personalsite.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
