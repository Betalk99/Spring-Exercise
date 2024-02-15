package com.bruno.Servizi.File.Upload.controllers;

import com.bruno.Servizi.File.Upload.dto.DownloadProfilePictureDTO;
import com.bruno.Servizi.File.Upload.entities.User;
import com.bruno.Servizi.File.Upload.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/upload/photo/{id}")
    @ResponseBody
    @SneakyThrows
    public User uploadPhoto(@PathVariable Long id, @RequestParam MultipartFile file) {
        return userService.uploadPhoto(id, file);
    }

    @GetMapping("/show/list")
    public List<User> list(){
        return userService.list();
    }

    @GetMapping("/show/{id}")
    public User showUser(@PathVariable Long id){
        return userService.showUser(id);
    }

    @GetMapping("/download/photo/{id}")
    @ResponseBody
    @SneakyThrows
    public byte[] downloadPhoto(@PathVariable Long id, HttpServletResponse response){
        return userService.downloadPhoto(id, response);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }









}
