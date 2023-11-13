package com.jakegodsall.personalsite.controller;

import com.jakegodsall.personalsite.payload.PostDto;
import com.jakegodsall.personalsite.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class PostController {
    private static final String PATH_V1_POST = "/api/v1/posts";
    private static final String PATH_V1_POST_ID = PATH_V1_POST + "/{postId}";
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(PATH_V1_POST)
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping(PATH_V1_POST)
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto post = postService.createPost(postDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();
        return ResponseEntity.created(location).body(post);
    }

    @GetMapping(PATH_V1_POST_ID)
    public ResponseEntity<PostDto> getPostById(@PathVariable long postId) {
        PostDto post = postService.getPostById(postId).get();
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping(PATH_V1_POST_ID)
    public ResponseEntity<PostDto> updatePostById(
            @RequestBody PostDto postDto,
            @PathVariable long postId
    ) {
        PostDto post = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping(PATH_V1_POST_ID)
    public ResponseEntity<Void> deletePostById(@PathVariable long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}
