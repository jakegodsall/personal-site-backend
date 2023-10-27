package com.jakegodsall.personalsite.service.impl;

import com.jakegodsall.personalsite.entity.Tag;
import com.jakegodsall.personalsite.payload.TagDto;
import com.jakegodsall.personalsite.repository.TagRepository;
import com.jakegodsall.personalsite.service.TagService;
import org.springframework.stereotype.Service;

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
    }

    @Override
    public TagDto createTag(TagDto dto) {
        return null;
    }

    @Override
    public TagDto updateTag(TagDto dto, long id) {
        return null;
    }

    @Override
    public void deleteTagById(long id) {

    }

    private TagDto mapToDto(Tag tag) {
        return TagDto.builder()
                .id(tag.getId())
                .lastModifiedDate(tag.getLastModifiedDate())
                .createdDate(tag.getCreatedDate())
                .name(tag.getName())
                .build();
    }

    private Tag mapToEntity(TagDto dto) {
        return new Tag();
    }
}
