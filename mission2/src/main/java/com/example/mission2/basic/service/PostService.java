package com.example.mission2.basic.service;

import com.example.mission2.basic.model.PostDto;

import java.util.Collection;
import java.util.List;

public interface PostService {
    PostDto createPost(int boardId, PostDto postDto);
    Collection<PostDto> readAllPost(int boardId);
    PostDto readPost(int boardId, int postId);
    boolean updatePost(int boardId, int postId, PostDto postDto);
    boolean deletePost(int boardId, int postId, int password);
}
