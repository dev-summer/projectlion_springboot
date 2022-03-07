package com.example.mission3.dto;

import com.example.mission3.entity.PostEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

public class BoardDto {
    private Long id;
    @NotBlank
    @Size(max = 10)
    private String name;
    private Collection<PostEntity> postEntityList;

    public BoardDto() {
    }

    public BoardDto(Long id, String name, Collection<PostEntity> postEntityList) {
        this.id = id;
        this.name = name;
        this.postEntityList = postEntityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    public void setPostEntityList(Collection<PostEntity> postEntityList) {
        this.postEntityList = postEntityList;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postEntityList=" + postEntityList +
                '}';
    }
}
