package com.jakegodsall.personalsite.service;

import com.jakegodsall.personalsite.payload.TagDto;

import java.util.List;

public interface TagService {
    List<TagDto> getAllTags();
    TagDto getTagById(long id);
    TagDto createTag(TagDto dto);
    TagDto updateTag(TagDto dto, long id);
    void deleteTagById(long id);
}
