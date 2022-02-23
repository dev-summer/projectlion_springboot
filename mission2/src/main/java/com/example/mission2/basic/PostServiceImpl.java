package com.example.mission2.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);
    private final PostRepository postRepository;

    public PostServiceImpl(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto postDto) {
        if(!this.postRepository.save(postDto)){
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public List<PostDto> readAllPost() {
        return this.postRepository.findAllPost();
    }

    @Override
    public PostDto readPost(int postId) {
        return this.postRepository.findById(postId);
    }

    @Override
    public void updatePost(int postId, PostDto postDto) {
        this.postRepository.update(postId, postDto);
    }

    @Override
    public void deletePost(int postId, int password) {
        if (this.postRepository.findById(postId).getPassword() == password){
            this.postRepository.delete(postId, password);
        } else throw new RuntimeException("password does not match");
    }
}
