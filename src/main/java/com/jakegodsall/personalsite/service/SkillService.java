package com.jakegodsall.personalsite.service;

import com.jakegodsall.personalsite.payload.SkillDto;
import java.util.List;
import java.util.Optional;

public interface SkillService {
    List<SkillDto> getAllSkills();
    SkillDto createSkill(SkillDto dto);
    Optional<SkillDto> getSkillById(long id);
    SkillDto updateSkillById(SkillDto dto, long id);
    void deleteSkillById(long id);
}
