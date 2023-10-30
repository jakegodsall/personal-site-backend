package com.jakegodsall.personalsite.service.impl;

import com.jakegodsall.personalsite.entity.Post;
import com.jakegodsall.personalsite.exceptions.ResourceNotFoundException;
import com.jakegodsall.personalsite.payload.PostDto;
import com.jakegodsall.personalsite.repository.PostRepository;
import com.jakegodsall.personalsite.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public PostDto getPostById(long id) {
        // get the entity from the db
        Post post = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        );
        // map to DTO and return
        return mapToDto(post);
    }

    @Override
    public PostDto createPost(PostDto dto) {
        // Create entity from DTO
        Post post = mapToEntity(dto);

        // Set read-only fields
        LocalDateTime createdDate = LocalDateTime.now();
        post.setCreatedDate(createdDate);
        post.setLastModifiedDate(createdDate);

        // Save in the database
        Post postInDb = repository.save(post);

        // Convert to DTO and return
        return mapToDto(postInDb);
    }

    @Override
    public PostDto updatePost(PostDto dto, long id) {
        // Get the entity from the db
        Post post = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        );
        // Update the fields by the DTO
        post.setLastModifiedDate(LocalDateTime.now());
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getContent());
        // Save the updated entity in the db
        Post postInDb = repository.save(post);
        // Map to DTO and return
        return mapToDto(postInDb);
    }

    @Override
    public void deletePost(long id) {
        // Get the entity from the database
        Post post = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        );
        // Delete the entity
        repository.delete(post);
    }

    private PostDto mapToDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setLastModifiedDate(post.getLastModifiedDate());
        dto.setCreatedDate(post.getCreatedDate());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    private Post mapToEntity(PostDto dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setLastModifiedDate(dto.getLastModifiedDate());
        post.setCreatedDate(dto.getCreatedDate());
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getDescription());
        return post;
    }
}
