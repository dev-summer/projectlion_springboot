package com.example.mission3.controller;

import com.example.mission3.dto.BoardDto;
import com.example.mission3.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("board")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardService boardService;

    public BoardController(@Autowired BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBoard(@RequestBody BoardDto dto){
        this.boardService.createBoard(dto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BoardDto readBoard(@PathVariable("id") Long id){
        return this.boardService.readBoard(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public Collection<BoardDto> readAllBoard(){
        return this.boardService.readAllBoard();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBoard(@PathVariable("id") Long id,
                            @RequestBody BoardDto dto){
        this.boardService.updateBoard(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBoard(@PathVariable("id") Long id){
        this.boardService.deleteBoard(id);
    }

}
