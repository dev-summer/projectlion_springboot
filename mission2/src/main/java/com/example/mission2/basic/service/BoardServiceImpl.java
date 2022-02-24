package com.example.mission2.basic.service;

import com.example.mission2.basic.model.BoardDto;
import com.example.mission2.basic.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BoardServiceImpl implements BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
    private final BoardRepository boardRepository;

    public BoardServiceImpl(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public BoardDto createBoard(BoardDto boardDto) {
        return this.boardRepository.create(boardDto);
    }

    @Override
    public Collection<BoardDto> readAllBoard() {
        return this.boardRepository.readAll();
    }

    @Override
    public BoardDto readBoard(int boardId) {
        return this.boardRepository.read(boardId);
    }

    @Override
    public boolean updateBoard(int boardId, BoardDto boardDto) {
        this.boardRepository.update(boardId,boardDto);
        return true;
    }

    @Override
    public boolean deleteBoard(int boardId) {
        this.boardRepository.delete(boardId);
        return true;
    }
}
