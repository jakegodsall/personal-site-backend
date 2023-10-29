package com.jakegodsall.personalsite.repository;

import com.jakegodsall.personalsite.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
