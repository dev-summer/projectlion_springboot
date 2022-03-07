package com.example.mission3.controller;

import com.example.mission3.dto.PostDto;
import com.example.mission3.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("board/{boardId}/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto dto){
        this.postService.createPost(dto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public PostDto readPost(@PathVariable("id") Long id){
        return this.postService.readPost(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public Collection<PostDto> readAllPost(){
        return this.postService.readAllPost();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") Long id,
                           @RequestParam("password") Long password,
                           @RequestBody PostDto dto){
        this.postService.updatePost(id, password, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable("id") Long id,
                           @RequestParam("password") Long password){
        this.postService.deletePost(id, password);
    }

}
