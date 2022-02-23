package com.example.mission2.basic;

import java.util.List;

public interface BoardService {
    void createBoard(BoardDto boardDto);
    List<BoardDto> readAllBoard();
    BoardDto readBoard(int boardId);
    void updateBoard(int boardId, BoardDto boardDto);
    void deleteBoard(int boardId);
}
