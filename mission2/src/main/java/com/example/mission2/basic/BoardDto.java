package com.example.mission2.basic;

public class BoardDto {
    private int boardId;
    private String boardName;

    public BoardDto() {
    }

    public BoardDto(int boardId, String boardName) {
        this.boardId = boardId;
        this.boardName = boardName;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "boardId=" + boardId +
                ", boardName='" + boardName + '\'' +
                '}';
    }
}
