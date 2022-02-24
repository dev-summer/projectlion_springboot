package com.example.mission2.basic.controller;

import com.example.mission2.basic.service.PostService;
import com.example.mission2.basic.model.PostDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.Collection;
import java.util.ResourceBundle;

@RestController
@RequestMapping("board/{boardId}/post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;

    public PostRestController(
            @Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                              @PathVariable(name = "boardId") int boardId){
        PostDto result = this.postService.createPost(boardId, postDto);
        return ResponseEntity.ok(result.passwordMasked());
    }

    @GetMapping()
    public ResponseEntity<Collection<PostDto>> readAllPost(@PathVariable("boardId") int boardId){
        Collection<PostDto> postList = this.postService.readAllPost(boardId);
        if (postList == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(postList);
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDto> readPost(@PathVariable("boardId") int boardId,
                                                        @PathVariable("postId") int postId){
        PostDto postDto = this.postService.readPost(boardId, postId);
        if (postDto == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(postDto.passwordMasked());
    }

    @PutMapping("{postId}")
    public ResponseEntity<?> updatePost(@PathVariable("boardId") int boardId,
                                        @PathVariable("postId") int postId,
                                        @RequestBody PostDto postDto){
        if (!postService.updatePost(boardId,postId,postDto)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePost(@PathVariable("boardId") int boardId,
                                        @PathVariable("postId") int postId,
                                        @RequestParam("password") int password){
        if (!postService.deletePost(boardId,postId, password)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
