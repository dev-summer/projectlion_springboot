package com.example.mission3.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="board_name")
    private String name;

    @OneToMany(
            targetEntity = PostEntity.class,
        fetch = FetchType.LAZY,
        mappedBy = "boardEntity")
    private Collection<PostEntity> postEntityList = new ArrayList<>();

    public BoardEntity() {
    }

    public BoardEntity(Long id, String name, Collection<PostEntity> postEntityList) {
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
        return "BoardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postEntityList=" + postEntityList +
                '}';
    }
}