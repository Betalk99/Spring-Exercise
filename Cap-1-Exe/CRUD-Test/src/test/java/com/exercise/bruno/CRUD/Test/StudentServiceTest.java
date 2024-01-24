package com.exercise.bruno.CRUD.Test;

import static org.assertj.core.api.Assertions.assertThat;
import com.exercise.bruno.CRUD.Test.entities.Student;
import com.exercise.bruno.CRUD.Test.repositories.StudentRepository;
import com.exercise.bruno.CRUD.Test.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@SpringBootTest
@TestPropertySource(value = {"classpath:application-test.properties"})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void upgradeStudentTest(){
        Student student = new Student();
        student.setName("Bruno");
        student.setSurname("Orlandi");
        student.setIsWorking(false);

        Student student1 = studentRepository.save(student);
        assertThat(student1).isNotNull();

        Student studService = studentService.upgradeStudent(student.getId(), student);
        assertThat(studService.getId()).isNotNull();
        assertThat(studService.getIsWorking()).isFalse();

        Student studFromID = studentRepository.findById(student1.getId()).get();
        assertThat(studFromID).isNotNull();
        assertThat(studFromID.getId()).isNotNull();
        assertThat(studFromID.getId()).isEqualTo(student1.getId());
        assertThat(studFromID.getIsWorking()).isFalse();



    }


}
