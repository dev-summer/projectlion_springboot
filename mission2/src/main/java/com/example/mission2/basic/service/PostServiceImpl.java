package com.example.mission2.basic.service;

import com.example.mission2.basic.model.BoardDto;
import com.example.mission2.basic.model.PostDto;
import com.example.mission2.basic.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);
    private final PostRepository postRepository;

    public PostServiceImpl(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(int boardId, PostDto postDto) {
        return this.postRepository.create(boardId, postDto);
    }

    @Override
    public Collection<PostDto> readAllPost(int boardId) {
        return this.postRepository.readAll(boardId);
    }

    @Override
    public PostDto readPost(int boardId, int postId) {
        return this.postRepository.read(boardId, postId);
    }

    @Override
    public boolean updatePost(int boardId, int postId, PostDto postDto) {
        this.postRepository.update(boardId, postId, postDto);
        return true;
    }

    @Override
    public boolean deletePost(int boardId, int postId, int password) {
        if (this.postRepository.read(boardId, postId).getPassword() == password){
            this.postRepository.delete(boardId, postId, password);
            return true;
        } else throw new RuntimeException("password does not match");
    }
}
