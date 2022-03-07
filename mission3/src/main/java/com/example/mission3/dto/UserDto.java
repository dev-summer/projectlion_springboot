package com.example.mission3.dto;

import com.example.mission3.entity.PostEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

public class UserDto {
    private Long id;
    @NotBlank
    @Size(max = 10)
    private String name;
    @NotBlank
    @Size(min = 6, max = 12)
    private Long password;
    private Collection<PostEntity> postEntityList;

    public UserDto() {
    }

    public UserDto(Long id, String name, Long password, Collection<PostEntity> postEntityList) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public Collection<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    public void setPostEntityList(Collection<PostEntity> postEntityList) {
        this.postEntityList = postEntityList;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                ", postEntityList=" + postEntityList +
                '}';
    }
}
