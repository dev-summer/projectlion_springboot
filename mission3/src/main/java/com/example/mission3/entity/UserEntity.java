package com.example.mission3.entity;

import javax.persistence.*;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name")
    private String name;
    private Long password;

    @OneToMany(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity")
    private Collection<PostEntity> postEntityList = new ArrayList<>();

    private AreaEntity areaEntity;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, Long password, Collection<PostEntity> postEntityList, AreaEntity areaEntity) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.postEntityList = postEntityList;
        this.areaEntity = areaEntity;
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

    public AreaEntity getAreaEntity() {
        return areaEntity;
    }

    public void setAreaEntity(AreaEntity areaEntity) {
        this.areaEntity = areaEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                ", postEntityList=" + postEntityList +
                ", areaEntity=" + areaEntity +
                '}';
    }
}
