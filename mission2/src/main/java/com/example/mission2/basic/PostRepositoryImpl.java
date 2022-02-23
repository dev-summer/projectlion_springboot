package com.example.mission2.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository{
    private static final Logger logger = LoggerFactory.getLogger(PostRepositoryImpl.class);
    private final List<PostDto> postList;

    public PostRepositoryImpl(List<PostDto> postList) {
        this.postList = postList;
    }

    @Override
    public boolean save(PostDto postDto) {
        this.postList.add(postDto);
        return true;
    }

    @Override
    public List<PostDto> findAllPost() {
        return this.postList;
    }

    @Override
    public PostDto findById(int postId) {
        return this.postList.get(postId);
    }

    @Override
    public boolean update(int postId, PostDto postDto) {
        PostDto targetPost = this.postList.get(postId);
        if (postDto.getTitle() != null){
            targetPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null){
            targetPost.setContent(postDto.getContent());
        }
        if (postDto.getAuthor() != null){
            targetPost.setAuthor(postDto.getAuthor());
        }
        return true;
    }

    @Override
    public boolean delete(int postId, int password) {
        PostDto targetPost = this.postList.get(postId);
        if (targetPost.getPassword() == password){
            this.postList.remove(postId);
        } else throw new RuntimeException("password does not match.");
        return true;
    }
}
