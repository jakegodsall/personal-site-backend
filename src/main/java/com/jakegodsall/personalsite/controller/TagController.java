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
@RequestMapping("/api/v1/tags")
public class TagController {

    private final TagService service;

    public TagController(TagService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags() {
        List<TagDto> tags = service.getAllTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TagDto> createTag(@RequestBody TagDto dto) {
        TagDto tag = service.createTag(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(tag.getId())
                .toUri();
        return ResponseEntity.created(location).body(tag);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> getTagById(@PathVariable long id) {
        TagDto tag = service.getTagById(id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDto> updateTagById(
            @RequestBody TagDto dto,
            @PathVariable long id
    ) {
        TagDto tag = service.updateTag(dto, id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTagById(@PathVariable long id) {
        service.deleteTagById(id);
        return ResponseEntity.noContent().build();
    }
}
