package com.example.mission2.basic.repository;

import com.example.mission2.basic.model.BoardDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
    private int lastIndex = 0;
    private final Map<Integer, BoardDto> memory = new HashMap<>();

    @Override
    public BoardDto create(BoardDto boardDto) {
        lastIndex++;
        boardDto.setBoardId(lastIndex);
        memory.put(lastIndex, boardDto);
        return memory.get(lastIndex);
    }

    @Override
    public Collection<BoardDto> readAll() {
        return memory.values();
    }

    @Override
    public BoardDto read(int boardId) {
        return memory.getOrDefault(boardId, null);
    }

    @Override
    public boolean update(int boardId, BoardDto boardDto) {
        if (memory.containsKey(boardId)){
            boardDto.setBoardId(boardId);
            memory.put(boardId, boardDto);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int boardId) {
        if (memory.containsKey(boardId)){
            memory.remove(boardId);
            return true;
        }
        return false;
    }
}
