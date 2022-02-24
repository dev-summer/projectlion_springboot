package com.example.mission2.basic.model;

public class PostDto {
    private int postId;
    private String title;
    private String content;
    private String author;
    private int password;
    private int boardId;
    // 변수가 총 6가지 사용되었는데, getter/setter를 직접 작성하지 않아도 될 수 있도록 @lombok 라이브러리를 사용할 수도 있음
    // 한 모델 클래스 내에 변수가 7개가 넘어가기 시작하면 변수 디자인이 잘 되었다고 보기 어려움

    public PostDto() {
    }

    public PostDto(int postId, String title, String content, String author, int password, int boardId) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
        this.boardId = boardId;
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

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", password=" + password +
                ", boardId=" + boardId +
                '}';
    }

    public PostDto passwordMasked(){
        return new PostDto(
                this.postId,
                this.title,
                this.content,
                this.author,
                0000,
                this.boardId
        );
    }
}
