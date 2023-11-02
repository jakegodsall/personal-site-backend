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
@RequestMapping("/api/v1/skills")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SkillDto>> getAllSkills() {
        List<SkillDto> skills = service.getAllSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SkillDto> createSkill(@RequestBody SkillDto dto) {
        SkillDto skill = service.createSkill(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(skill.getId())
                .toUri();
        return ResponseEntity.created(location).body(skill);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDto> getSkillById(@PathVariable long id) {
        SkillDto skill = service.getSkillById(id);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillDto> updateSkillById(
            @RequestBody SkillDto dto,
            @PathVariable long id
    ) {
        SkillDto skill = service.updateSkillById(dto, id);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSkillById(@PathVariable long id) {
        service.deleteSkillById(id);
        return ResponseEntity.noContent().build();
    }
}
