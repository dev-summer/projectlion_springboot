package com.example.mission2.basic;

import java.util.List;

public interface BoardRepository {
    boolean save(BoardDto boardDto);
    List<BoardDto> findAllBoard();
    BoardDto findById(int boardId);
    boolean update(int boardId, BoardDto boardDto);
    boolean delete(int boardId);

}
