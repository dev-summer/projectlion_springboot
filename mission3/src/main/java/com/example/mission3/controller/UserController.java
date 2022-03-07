package com.example.mission3.controller;

import com.example.mission3.dto.UserDto;
import com.example.mission3.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(@Autowired UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto dto){
        this.userService.createUser(dto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public UserDto readUser(@PathVariable("id") Long id){
        return this.userService.readUser(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public Collection<UserDto> readAllUser(){
        return this.userService.readAllUser();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBoard(@PathVariable("id") Long id,
                            @RequestBody UserDto dto,
                            @RequestParam("password") Long password){
        this.userService.updateUser(id, password, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBoard(@PathVariable("id") Long id,
                            @RequestParam("password") Long password){
        this.userService.deleteUser(id, password);
    }
}
