package com.example.mission2.basic;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;

@RestController
@RequestMapping("board")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;

    public PostRestController(
            @Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping("{boardName}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto,
                           @PathVariable(name = "boardName") String boardName){
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> readAllPost(){
        logger.info("read in all");
        return this.postService.readAllPost();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto readPost(@PathVariable("id") int id){
        logger.info("read specific post");
        return this.postService.readPost(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id,
                           @RequestBody PostDto postDto){
        logger.info("updated post id: " + id);
        logger.info("updated: " + postDto);
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("postId") int id, @PathVariable("password") int password){
        logger.info("deleted post id: " + id);
        this.postService.deletePost(id, password);
    }
}
