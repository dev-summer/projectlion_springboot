package com.example.mission2.basic.controller;

import com.example.mission2.basic.model.BoardDto;
import com.example.mission2.basic.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("board")
public class BoardRestController {
    private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping()
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto){
        return ResponseEntity.ok(boardService.createBoard(boardDto));
    }

    @GetMapping()
    public ResponseEntity<Collection<BoardDto>> readAllBoard(){
        return ResponseEntity.ok(this.boardService.readAllBoard());
    }

    @GetMapping("{id}")
    public ResponseEntity<BoardDto> readBoard(@PathVariable("id") int id){
        BoardDto dto = boardService.readBoard(id);
        if (dto == null) { return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBoard(@PathVariable("id") int id,
                           @RequestBody BoardDto boardDto){
        if(!boardService.updateBoard(id,boardDto)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("boardId") int id){
        if(!boardService.deleteBoard(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
