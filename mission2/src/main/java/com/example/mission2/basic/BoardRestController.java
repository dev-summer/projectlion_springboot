package com.example.mission2.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public void createBoard(@RequestBody BoardDto boardDto){
        logger.info(boardDto.toString());
        this.boardService.createBoard(boardDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BoardDto> readAllBoard(){
        logger.info("read in all");
        return this.boardService.readAllBoard();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public BoardDto readBoard(@PathVariable("id") int id){
        logger.info("read specific board");
        return this.boardService.readBoard(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBoard(@PathVariable("id") int id,
                           @RequestBody BoardDto boardDto){
        logger.info("updated board id: " + id);
        logger.info("updated: " + boardDto);
        this.boardService.updateBoard(id, boardDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBoard(@PathVariable("boardId") int id){
        logger.info("deleted board id: " + id);
        this.boardService.deleteBoard(id);
    }
}
