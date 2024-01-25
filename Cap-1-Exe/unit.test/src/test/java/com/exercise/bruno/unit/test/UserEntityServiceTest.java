package com.exercise.bruno.unit.test;

import static org.assertj.core.api.Assertions.assertThat;
import com.exercise.bruno.unit.test.entities.UserEntity;
import com.exercise.bruno.unit.test.repositories.UserRepository;
import com.exercise.bruno.unit.test.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(value = {"classpath:application-test.properties"})
public class UserEntityServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void upgradeUserName(){
        UserEntity user = new UserEntity();
        user.setNome("Bruno");
        user.setCognome("Orlandi");

        UserEntity user1 = userRepository.save(user);
        assertThat(user1).isNotNull();

        UserEntity userServ = userService.upgradeName(user.getId(), user);
        assertThat(userServ.getId()).isNotNull();
        assertThat(userServ.getNome()).isNotNull();

        UserEntity userFromID = userRepository.findById(user1.getId()).get();
        assertThat(userFromID).isNotNull();
        assertThat(userFromID.getId()).isNotNull();
        assertThat(userFromID.getId()).isEqualTo(user1.getId());
        assertThat(userFromID.getNome()).isNotNull();











    }




}
