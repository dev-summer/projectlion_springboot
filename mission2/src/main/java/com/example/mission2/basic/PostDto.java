package com.example.mission2.basic;

public class PostDto {
    private int postId;
    private String title;
    private String content;
    private String author;
    private int password;
    private BoardDto boardDto;

    public PostDto() {
    }

    public PostDto(int postId, String title, String content, String author, int password, BoardDto boardDto) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
        this.boardDto = boardDto;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public BoardDto getBoardDto() {
        return boardDto;
    }

    public void setBoardDto(BoardDto boardDto) {
        this.boardDto = boardDto;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", password=" + password +
                ", boardDto=" + boardDto +
                '}';
    }
}
