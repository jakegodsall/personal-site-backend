package com.jakegodsall.personalsite.service;

import com.jakegodsall.personalsite.payload.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostDto> getAllPosts();
    PostDto createPost(PostDto dto);
    Optional<PostDto> getPostById(long id);
    PostDto updatePost(PostDto dto, long id);
    void deletePost(long id);
}
