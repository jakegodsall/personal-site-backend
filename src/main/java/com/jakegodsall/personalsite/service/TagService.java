package com.jakegodsall.personalsite.service;

import com.jakegodsall.personalsite.payload.TagDto;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<TagDto> getAllTags();
    TagDto createTag(TagDto dto);
    Optional<TagDto> getTagById(long id);
    TagDto updateTag(TagDto dto, long id);
    void deleteTagById(long id);
}
