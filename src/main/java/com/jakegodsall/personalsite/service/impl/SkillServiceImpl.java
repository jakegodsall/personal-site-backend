package com.jakegodsall.personalsite.service.impl;

import com.jakegodsall.personalsite.entity.Skill;
import com.jakegodsall.personalsite.exceptions.ResourceNotFoundException;
import com.jakegodsall.personalsite.payload.SkillDto;
import com.jakegodsall.personalsite.repository.SkillRepository;
import com.jakegodsall.personalsite.service.SkillService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;

    public SkillServiceImpl(SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SkillDto> getAllSkills() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public SkillDto createSkill(SkillDto dto) {
        // Create entity from the DTO
        Skill skill = mapToEntity(dto);

        // Update read-only fields
        LocalDateTime currentTime = LocalDateTime.now();
        skill.setLastModifiedDate(currentTime);
        skill.setCreatedDate(currentTime);

        // Store the entity in the db
        Skill skillFromDb = repository.save(skill);

        // Map the stored entity to DTO and return
        return mapToDto(skillFromDb);
    }

    @Override
    public SkillDto getSkillById(long id) {
        Skill skillFromDb = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Skill", "id", id)
        );
        return mapToDto(skillFromDb);
    }

    @Override
    public SkillDto updateSkillById(SkillDto dto, long id) {
        // Get the entity from the database
        Skill skillFromDb = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Skill", "id", id)
        );
        // Update the values of teh entity from the DTO
        skillFromDb.setLastModifiedDate(LocalDateTime.now());
        skillFromDb.setName(dto.getName());

        // Save the entity in the database
        Skill updatedSkill = repository.save(skillFromDb);

        // Map the saved entity to DTO and return
        return mapToDto(updatedSkill);
    }

    @Override
    public void deleteSkillById(long id) {
        Skill skillFromDb = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Skill", "id", id)
        );
        repository.delete(skillFromDb);
    }

    private SkillDto mapToDto(Skill skill) {
        SkillDto dto = new SkillDto();
        dto.setId(skill.getId());
        dto.setLastModifiedDate(skill.getLastModifiedDate());
        dto.setCreatedDate(skill.getCreatedDate());
        dto.setName(skill.getName());
        return dto;
    }

    private Skill mapToEntity(SkillDto dto) {
        Skill skill = new Skill();
        skill.setId(dto.getId());
        skill.setLastModifiedDate(dto.getLastModifiedDate());
        skill.setCreatedDate(dto.getCreatedDate());
        skill.setName(dto.getName());
        return skill;
    }
}
