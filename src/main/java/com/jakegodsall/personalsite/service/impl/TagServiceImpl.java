package com.jakegodsall.personalsite.service.impl;

import com.jakegodsall.personalsite.entity.Tag;
import com.jakegodsall.personalsite.exceptions.ResourceNotFoundException;
import com.jakegodsall.personalsite.payload.TagDto;
import com.jakegodsall.personalsite.repository.TagRepository;
import com.jakegodsall.personalsite.service.TagService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository repository;

    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TagDto> getAllTags() {
        return repository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public TagDto getTagById(long id) {
        // get the tag from the db
        Tag tag = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Tag", "id", id)
        );

        // map to DTO and return
        return mapToDto(tag);
    }

    @Override
    public TagDto createTag(TagDto dto) {
        // Create an entity from the DTO
        Tag tag = mapToEntity(dto);

        // Set read-only fields
        LocalDateTime createdDate = LocalDateTime.now();
        tag.setCreatedDate(createdDate);
        tag.setLastModifiedDate(createdDate);

        // Store it in the database
        Tag tagInDb = repository.save(tag);

        // Convert the stored entity to DTO and return

        return mapToDto(tagInDb);
    }

    @Override
    public TagDto updateTag(TagDto dto, long id) {
        // Get the entity by id
        Tag tag = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Tag", "id", id)
        );
        // update the entity with the values from the DTO
        tag.setLastModifiedDate(LocalDateTime.now());
        tag.setName(dto.getName());
        // Save the entity in the db
        Tag tagInDb = repository.save(tag);
        // Map to DTO and return
        return mapToDto(tagInDb);
    }

    @Override
    public void deleteTagById(long id) {
        // Get the entity by id
        Tag tag = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Tag", "id", id)
        );
        // Delete the entity
        repository.delete(tag);
    }

    private TagDto mapToDto(Tag tag) {
        TagDto dto = new TagDto();
        dto.setId(tag.getId());
        dto.setLastModifiedDate(tag.getLastModifiedDate());
        dto.setCreatedDate(tag.getCreatedDate());
        dto.setName(tag.getName());
        return dto;
    }

    private Tag mapToEntity(TagDto dto) {
        Tag tag = new Tag();
        tag.setId(dto.getId());
        tag.setLastModifiedDate(dto.getLastModifiedDate());
        tag.setCreatedDate(dto.getCreatedDate());
        tag.setName(dto.getName());
        return tag;
    }
}
