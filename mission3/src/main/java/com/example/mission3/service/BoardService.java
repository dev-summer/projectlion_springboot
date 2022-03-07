package com.example.mission3.service;

import com.example.mission3.controller.BoardController;
import com.example.mission3.dto.BoardDto;
import com.example.mission3.entity.BoardEntity;
import com.example.mission3.repository.BoardDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Service
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
    private final BoardDao boardDao;

    public BoardService (@Autowired BoardDao boardDao){
        this.boardDao = boardDao;
    }

    public void createBoard(BoardDto dto){
        this.boardDao.createBoard(dto);
    }

    public BoardDto readBoard(Long id){
        BoardEntity boardEntity = this.boardDao.readBoard(id);
        return new BoardDto(
                boardEntity.getId(),
                boardEntity.getName(),
                boardEntity.getPostEntityList()
        );
    }

    public Collection<BoardDto> readAllBoard(){
        Iterator<BoardEntity> iterator = this.boardDao.readAllBoard();
        Collection<BoardDto> boardDtoList = new ArrayList<>();

        while (iterator.hasNext()){
            BoardEntity boardEntity = iterator.next();
            boardDtoList.add( new BoardDto(
                    boardEntity.getId(),
                    boardEntity.getName(),
                    boardEntity.getPostEntityList())
            );
        }
        return boardDtoList;
    }

    public void updateBoard(Long id, BoardDto dto){
        this.boardDao.updateBoard(id, dto);
    }

    public void deleteBoard(Long id){
        this.boardDao.deleteBoard(id);
    }
}
