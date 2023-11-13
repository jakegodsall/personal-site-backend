package com.jakegodsall.personalsite.controller;

import com.jakegodsall.personalsite.payload.SkillDto;
import com.jakegodsall.personalsite.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SkillController {

    private static final String PATH_V1_SKILL = "/api/v1/skills";
    private static final String PATH_V1_SKILL_ID = PATH_V1_SKILL + "/{skillId}";

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping(PATH_V1_SKILL)
    public ResponseEntity<List<SkillDto>> getAllSkills() {
        List<SkillDto> skills = skillService.getAllSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @PostMapping(PATH_V1_SKILL)
    public ResponseEntity<SkillDto> createSkill(@RequestBody SkillDto dto) {
        SkillDto skill = skillService.createSkill(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(skill.getId())
                .toUri();
        return ResponseEntity.created(location).body(skill);
    }

    @GetMapping(PATH_V1_SKILL_ID)
    public ResponseEntity<SkillDto> getSkillById(@PathVariable long skillId) {
        SkillDto skill = skillService.getSkillById(skillId).get();
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PutMapping(PATH_V1_SKILL_ID)
    public ResponseEntity<SkillDto> updateSkillById(
            @RequestBody SkillDto dto,
            @PathVariable long skillId
    ) {
        SkillDto skill = skillService.updateSkillById(dto, skillId);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @DeleteMapping(PATH_V1_SKILL_ID)
    public ResponseEntity<Void> deleteSkillById(@PathVariable long skillId) {
        skillService.deleteSkillById(skillId);
        return ResponseEntity.noContent().build();
    }
}
