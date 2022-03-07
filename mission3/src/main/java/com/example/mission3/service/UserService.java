package com.example.mission3.service;

import com.example.mission3.dto.UserDto;
import com.example.mission3.entity.UserEntity;
import com.example.mission3.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserDao userDao;

    public UserService(@Autowired UserDao userDao){
        this.userDao = userDao;
    }

    public void createUser(UserDto dto){
        this.userDao.createUser(dto);
    }

    public UserDto readUser(Long id){
        UserEntity userEntity = this.userDao.readUser(id);
        return new UserDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.getPostEntityList()
        );
    }

    public Collection<UserDto> readAllUser(){
        Iterator<UserEntity> iterator = this.userDao.readAllUser();
        Collection<UserDto> userDtoList = new ArrayList<>();

        while (iterator.hasNext()){
            UserEntity userEntity = iterator.next();
            userDtoList.add(new UserDto(
                    userEntity.getId(),
                    userEntity.getName(),
                    userEntity.getPassword(),
                    userEntity.getPostEntityList())
            );
        }
        return userDtoList;
    }

    public void updateUser(Long id, Long password, UserDto dto){
        this.userDao.updateUser(id, password, dto);
    }

    public void deleteUser(Long id, Long password){
        this.userDao.deleteUser(id, password);
    }

}
