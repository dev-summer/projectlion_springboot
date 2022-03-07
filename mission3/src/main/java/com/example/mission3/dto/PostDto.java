package com.example.mission3.dto;

import com.example.mission3.entity.BoardEntity;
import com.example.mission3.entity.UserEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostDto {
    private Long id;
    @NotBlank
    @Size(max = 40)
    private String title;
    @NotBlank
    @Size(max = 40)
    private String content;
    @NotBlank
    @Size(min = 6, max = 12)
    private Long password;
    private BoardEntity boardEntity;
    private UserEntity userEntity;

    public PostDto() {
    }

    public PostDto(Long id, String title, String content, Long password, BoardEntity boardEntity, UserEntity userEntity) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.password = password;
        this.boardEntity = boardEntity;
        this.userEntity = userEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public BoardEntity getBoardEntity() {
        return boardEntity;
    }

    public void setBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", password=" + password +
                ", boardEntity=" + boardEntity +
                ", userEntity=" + userEntity +
                '}';
    }
}
