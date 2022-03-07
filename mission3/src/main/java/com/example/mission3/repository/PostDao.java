package com.example.mission3.repository;

import com.example.mission3.dto.PostDto;
import com.example.mission3.entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class PostDao {
    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostRepository postRepository;

    public PostDao(@Autowired PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public void createPost(PostDto dto){
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        postEntity.setBoardEntity(dto.getBoardEntity());
        postEntity.setUserEntity(dto.getUserEntity());
    }

    public PostEntity readPost(Long id){
        Optional<PostEntity> postEntity = this.postRepository.findById(id);
        if (postEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return postEntity.get();
    }

    public Iterator<PostEntity> readAllPost(){
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(Long id, Long password, PostDto dto){
        Optional<PostEntity> targetEntity = this.postRepository.findById(id);
        if (targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PostEntity postEntity = targetEntity.get();
        if (postEntity.getPassword() != dto.getPassword()){
            throw new RuntimeException("password does not match");
        }
        postEntity.setTitle(dto.getTitle() == null ? postEntity.getTitle() : dto.getTitle());
        postEntity.setContent(dto.getContent() == null ? postEntity.getContent() : dto.getContent());
        this.postRepository.save(postEntity);
    }

    public void deletePost(Long id, Long password){
        Optional<PostEntity> targetEntity = this.postRepository.findById(id);
        if (targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PostEntity postEntity = targetEntity.get();
        if (targetEntity.get().getPassword() != password){
            throw new RuntimeException("password does not match");
        }
        this.postRepository.delete(targetEntity.get());
    }
}
