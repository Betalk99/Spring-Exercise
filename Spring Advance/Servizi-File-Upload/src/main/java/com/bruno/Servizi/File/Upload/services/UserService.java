package com.bruno.Servizi.File.Upload.services;

import com.bruno.Servizi.File.Upload.dto.DownloadProfilePictureDTO;
import com.bruno.Servizi.File.Upload.entities.User;
import com.bruno.Servizi.File.Upload.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpServletResponse;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileStorageService fileStorageService;

    public List<User> list(){
        return userRepository.findAll();
    }

    public User showUser(Long id){
        return userRepository.findById(id).get();
    }

    public User createUser(User userOne) {
        return userRepository.saveAndFlush(userOne);
    }
    @SneakyThrows
    public User uploadPhoto(Long id, MultipartFile file) {
        User user = userRepository.findById(id).get();
        if (user.getFoto() != null) {
            fileStorageService.delete(user.getFoto());
        }
        user.setFoto(fileStorageService.upload(file));
        return userRepository.saveAndFlush(user);
    }
    @SneakyThrows
    public byte[] downloadPhoto(Long id, HttpServletResponse response) {
        User user = userRepository.findById(id).get();
        return fileStorageService.download(user.getFoto(), response);

    }


    public void delete(Long id) {
        User user = userRepository.findById(id).get();
        if (user.getFoto() != null) {
            fileStorageService.delete(user.getFoto());
        }
        userRepository.deleteById(id);
    }
}
