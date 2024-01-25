package com.exercise.bruno.unit.test.service;

import com.exercise.bruno.unit.test.entities.UserEntity;
import com.exercise.bruno.unit.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity upgradeName(Long id, UserEntity userEntity){
        UserEntity userEntity1 = userRepository.findById(id).get();
        userEntity1.setNome(userEntity.getNome());
        userRepository.save(userEntity1);
        return userEntity1;
    }

}
