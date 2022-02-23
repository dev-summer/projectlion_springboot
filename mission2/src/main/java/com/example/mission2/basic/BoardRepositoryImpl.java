package com.example.mission2.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepositoryImpl implements BoardRepository{
    private static final Logger logger = LoggerFactory.getLogger(BoardRepositoryImpl.class);
    private final List<BoardDto> boardList;

    public BoardRepositoryImpl(List<BoardDto> boardList) {
        this.boardList = boardList;
    }

    @Override
    public boolean save(BoardDto boardDto) {
        return this.boardList.add(boardDto);
    }

    @Override
    public List<BoardDto> findAllBoard() {
        return this.boardList;
    }

    @Override
    public BoardDto findById(int boardId) {
        return this.boardList.get(boardId);
    }

    @Override
    public boolean update(int boardId, BoardDto boardDto) {
        BoardDto targetBoard = this.boardList.get(boardId);
        if (boardDto.getBoardName() != null){
            targetBoard.setBoardName(boardDto.getBoardName());
        }
        this.boardList.set(boardId, targetBoard);
        return true;
    }

    @Override
    public boolean delete(int boardId) {
        this.boardList.remove(boardId);
        return true;
    }
}
