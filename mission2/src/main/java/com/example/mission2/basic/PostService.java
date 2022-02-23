package com.example.mission2.basic;

import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    void createPost(PostDto postDto);
    List<PostDto> readAllPost();
    PostDto readPost(int postId);
    void updatePost(int postId, PostDto postDto);
    void deletePost(int postId, int password);
}
