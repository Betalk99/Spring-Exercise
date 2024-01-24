package com.exercise.bruno.CRUD.Test.services;

import com.exercise.bruno.CRUD.Test.entities.Student;
import com.exercise.bruno.CRUD.Test.repositories.StudentRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    @JsonIgnoreProperties({"name", "surname", "id"})
    public Student upgradeStudent(Long id, Student student){
        Student s1 = studentRepository.findById(id).get();
        s1.setIsWorking(student.getIsWorking());
        studentRepository.save(s1);
        return s1;
    }
//    @JsonIgnoreProperties({"name", "surname", "isWorking"})
    public Student upgradeStudentID(Long id, Student student){
        Student s1 = studentRepository.getById(id);
        s1.setId(student.getId());
        studentRepository.save(s1);
        return s1;
    }


}
