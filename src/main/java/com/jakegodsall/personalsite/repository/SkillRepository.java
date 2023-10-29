package com.jakegodsall.personalsite.repository;

import com.jakegodsall.personalsite.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
