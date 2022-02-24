package com.example.mission2.basic.repository;

import com.example.mission2.basic.model.BoardDto;

import java.util.Collection;
import java.util.List;

public interface BoardRepository {
    BoardDto create(BoardDto boardDto);
    BoardDto read(int id);
    Collection<BoardDto> readAll();
    boolean update(int boardId, BoardDto boardDto);
    boolean delete(int boardId);
    // 반환값으로 boolean을 쓰는 이유: 원래 존재하는 데이터를 조작하는 함수이기 때문에 정상적으로 작동했는지 여부를 확인하기 위해
}
