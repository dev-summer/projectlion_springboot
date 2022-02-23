package com.example.mission2.basic;

import java.util.List;

public interface PostRepository {
    boolean save(PostDto postDto);
    List<PostDto> findAllPost();
    PostDto findById(int postId);
    boolean update(int postId, PostDto postDto);
    boolean delete(int postId, int password);
}
