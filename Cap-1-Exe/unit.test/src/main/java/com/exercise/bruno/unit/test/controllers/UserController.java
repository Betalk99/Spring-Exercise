package com.exercise.bruno.unit.test.controllers;

import com.exercise.bruno.unit.test.entities.UserEntity;
import com.exercise.bruno.unit.test.repositories.UserRepository;
import com.exercise.bruno.unit.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/create")
    public @ResponseBody UserEntity createUser(@RequestBody UserEntity userEntity){
        UserEntity userEntity1 = userRepository.saveAndFlush(userEntity);
        return userEntity1;
    }

    @GetMapping(path = "/list")
    public @ResponseBody List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/list/{id}")
    public @ResponseBody Optional<UserEntity> getUserID(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @PatchMapping(path = "/update/{id}")
    public @ResponseBody UserEntity upgradeUserNome(@PathVariable Long id, @RequestBody UserEntity userEntity){
        return userService.upgradeName(id, userEntity);
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody void deleteByID(@PathVariable Long id){
        userRepository.deleteById(id);
    }










}
