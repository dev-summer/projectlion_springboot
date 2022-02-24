package com.example.mission2.basic.service;

import com.example.mission2.basic.model.BoardDto;

import java.util.Collection;
import java.util.List;

public interface BoardService {
    BoardDto createBoard(BoardDto boardDto);
    Collection<BoardDto> readAllBoard();
    BoardDto readBoard(int boardId);
    boolean updateBoard(int boardId, BoardDto boardDto);
    boolean deleteBoard(int boardId);
}
