package com.example.mission2.basic.repository;

import com.example.mission2.basic.model.BoardDto;
import com.example.mission2.basic.model.PostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private final BoardRepository boardRepository;
    private int lastIndex = 0;
    private final Map<Integer, PostDto> memory = new HashMap<>();

    public PostRepositoryImpl(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public PostDto create(int boardId, PostDto postDto) {
        BoardDto boardDto = this.boardRepository.read(boardId);
        if (boardDto == null) {
            return null;
        }
        postDto.setBoardId(boardId);
        lastIndex++;
        postDto.setPostId(lastIndex);
        memory.put(lastIndex, postDto);
        return postDto;
    }

    @Override
    public Collection<PostDto> readAll(int boardId) {
        if (boardRepository.read(boardId) == null) return null;
        Collection<PostDto> postList = new ArrayList<>();
        memory.forEach((postId, postDto) -> {
            if (Objects.equals(postDto.getBoardId(), boardId))
                postList.add(postDto);
        });
        return postList;
    }

    @Override
    public PostDto read(int boardId, int postId) {
        PostDto postDto = memory.getOrDefault(postId, null);
        if (postDto == null) {
            return null;
        }
        else if (!Objects.equals(postDto.getBoardId(), boardId)){
            return null;
        }
        return postDto;
    }

    @Override
    public boolean update(int boardId, int postId, PostDto postDto) {
        PostDto targetPost = memory.getOrDefault(postId, null);
        if (targetPost == null){
            return false;
        } else if (!Objects.equals(targetPost.getBoardId(), boardId)){
            return false;
        }
        else if (targetPost.getPassword() != postDto.getPassword()) {
            return false;
        }
        targetPost.setTitle(
                postDto.getTitle() == null ? targetPost.getTitle() : postDto.getTitle());
        targetPost.setContent(
                postDto.getContent() == null ? targetPost.getContent() : postDto.getContent());
        return true;
    }

    @Override
    public boolean delete(int boardId, int postId, int password) {
        PostDto targetPost = memory.getOrDefault(postId, null);
        if (targetPost == null){
            return false;
        } else if (!Objects.equals(targetPost.getBoardId(), boardId)){
            return false;
        }
        else if (!Objects.equals(targetPost.getPassword(), password)) {
            return false;
        }
        memory.remove(postId);
        return true;
    }
}
