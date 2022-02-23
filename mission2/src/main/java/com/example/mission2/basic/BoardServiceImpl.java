package com.example.mission2.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
    private final BoardRepository boardRepository;

    public BoardServiceImpl(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void createBoard(BoardDto boardDto) {
        if(!this.boardRepository.save(boardDto)){
            throw new RuntimeException(("save failed"));
        }
    }

    @Override
    public List<BoardDto> readAllBoard() {
        return this.boardRepository.findAllBoard();
    }

    @Override
    public BoardDto readBoard(int boardId) {
        return this.boardRepository.findById(boardId);
    }

    @Override
    public void updateBoard(int boardId, BoardDto boardDto) {
        this.boardRepository.update(boardId,boardDto);
    }

    @Override
    public void deleteBoard(int boardId) {
        this.boardRepository.delete(boardId);
    }
}
