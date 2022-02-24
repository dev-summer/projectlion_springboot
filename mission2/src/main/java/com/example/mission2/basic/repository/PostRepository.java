package com.example.mission2.basic.repository;

import com.example.mission2.basic.model.PostDto;

import java.util.Collection;

public interface PostRepository {
    PostDto create(int boardId, PostDto postDto);
    PostDto read(int boardId, int postId);
    Collection<PostDto> readAll(int boardId);
    boolean update(int boardId, int postId, PostDto postDto);
    boolean delete(int boardId, int postId, int password);
}
