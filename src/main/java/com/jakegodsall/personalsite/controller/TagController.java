package com.jakegodsall.personalsite.controller;

import com.jakegodsall.personalsite.payload.TagDto;
import com.jakegodsall.personalsite.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TagController {
    private static final String PATH_V1_TAG = "/api/v1/tags";
    private static final String PATH_V1_TAG_ID = PATH_V1_TAG + "/{tagId}";
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(PATH_V1_TAG)
    public ResponseEntity<List<TagDto>> getAllTags() {
        List<TagDto> tags = tagService.getAllTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @PostMapping(PATH_V1_TAG)
    public ResponseEntity<TagDto> createTag(@RequestBody TagDto dto) {
        TagDto tag = tagService.createTag(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(tag.getId())
                .toUri();
        return ResponseEntity.created(location).body(tag);
    }

    @GetMapping(PATH_V1_TAG_ID)
    public ResponseEntity<TagDto> getTagById(@PathVariable long tagId) {
        TagDto tag = tagService.getTagById(tagId).get();
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @PutMapping(PATH_V1_TAG_ID)
    public ResponseEntity<TagDto> updateTagById(
            @RequestBody TagDto dto,
            @PathVariable long tagId
    ) {
        TagDto tag = tagService.updateTag(dto, tagId);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @DeleteMapping(PATH_V1_TAG_ID)
    public ResponseEntity<Void> deleteTagById(@PathVariable long tagId) {
        tagService.deleteTagById(tagId);
        return ResponseEntity.noContent().build();
    }
}
