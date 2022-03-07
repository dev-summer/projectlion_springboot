package com.example.mission3.service;

import com.example.mission3.dto.PostDto;
import com.example.mission3.entity.PostEntity;
import com.example.mission3.repository.PostDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostDao postDao;

    public PostService(@Autowired PostDao postDao) {
        this.postDao = postDao;
    }

    public void createPost(PostDto dto){
        this.postDao.createPost(dto);
    }

    public PostDto readPost(Long id){
        PostEntity postEntity = this.postDao.readPost(id);
        return new PostDto(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getPassword(),
                postEntity.getBoardEntity(),
                postEntity.getUserEntity()
        );
    }

    public Collection<PostDto> readAllPost(){
        Iterator<PostEntity> iterator = this.postDao.readAllPost();
        Collection<PostDto> postDtoList = new ArrayList<>();

        while (iterator.hasNext()){
            PostEntity postEntity = iterator.next();
            postDtoList.add(new PostDto(postEntity.getId(),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getPassword(),
                    postEntity.getBoardEntity(),
                    postEntity.getUserEntity())
            );
        }

        return postDtoList;
    }

    public void updatePost(Long id, Long password, PostDto dto){
        this.postDao.updatePost(id, password, dto);
    }

    public void deletePost(Long id, Long password){
        this.postDao.deletePost(id, password);
    }
}
