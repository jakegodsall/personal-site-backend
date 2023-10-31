package com.jakegodsall.personalsite.service;

import com.jakegodsall.personalsite.payload.SkillDto;
import java.util.List;

public interface SkillService {
    List<SkillDto> getAllSkills();

    SkillDto createSkill(SkillDto dto);

    SkillDto getSkillById(long id);

    SkillDto updateSkillById(SkillDto dto, long id);

    void deleteSkillById(long id);
}
