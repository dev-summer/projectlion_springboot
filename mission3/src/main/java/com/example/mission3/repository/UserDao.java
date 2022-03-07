package com.example.mission3.repository;

import com.example.mission3.dto.UserDto;
import com.example.mission3.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    private final UserRepository userRepository;

    public UserDao(@Autowired UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(UserDto dto){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(dto.getName());
        userEntity.setPostEntityList(dto.getPostEntityList());
        this.userRepository.save(userEntity);
    }

    public UserEntity readUser(Long id){
        Optional<UserEntity> userEntity = this.userRepository.findById(id);
        if (userEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userEntity.get();
    }

    public Iterator<UserEntity> readAllUser(){
        return this.userRepository.findAll().iterator();
    }

    public void updateUser(Long id, Long password, UserDto dto){
        Optional<UserEntity> targetEntity = this.userRepository.findById(id);
        if (targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (targetEntity.get().getPassword() != password){
            throw new RuntimeException("password does not match");
        }
        UserEntity userEntity = targetEntity.get();
        userEntity.setName(dto.getName() == null ? userEntity.getName() : dto.getName());
        userEntity.setPassword(dto.getPassword() == null ? userEntity.getPassword() : dto.getPassword());
        userEntity.setPostEntityList(dto.getPostEntityList() == null ? userEntity.getPostEntityList() : dto.getPostEntityList());
    }

    public void deleteUser(Long id, Long password){
        Optional<UserEntity> targetEntity = this.userRepository.findById(id);
        if (targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (targetEntity.get().getPassword() != password){
            throw new RuntimeException("password does not match");
        }
        this.userRepository.delete(targetEntity.get());
    }


}
