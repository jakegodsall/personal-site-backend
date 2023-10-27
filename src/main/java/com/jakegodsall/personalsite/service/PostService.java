package com.jakegodsall.personalsite.service;

import com.jakegodsall.personalsite.payload.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);
    PostDto createPost(PostDto dto);
    PostDto updatePost(PostDto dto, long id);
    void deletePost(long id);
}
