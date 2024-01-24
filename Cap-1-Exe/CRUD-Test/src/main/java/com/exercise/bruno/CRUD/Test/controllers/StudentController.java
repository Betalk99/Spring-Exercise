package com.exercise.bruno.CRUD.Test.controllers;

import com.exercise.bruno.CRUD.Test.entities.Student;
import com.exercise.bruno.CRUD.Test.repositories.StudentRepository;
import com.exercise.bruno.CRUD.Test.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/create")
    public @ResponseBody Student createStudent(@RequestBody Student student){
        Student student1 = studentRepository.saveAndFlush(student);
        return student1;
    }

    @GetMapping(path = "/list")
    public List<Student> listStudent(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/list/{id}")
    public Optional<Student> listStudentID(@PathVariable Long id){
        return studentRepository.findById(id);
    }


    @PatchMapping(path = "/upgrade/{id}")
    public Student upgStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.upgradeStudent(id, student);
    }


//    @PatchMapping(path = "/upgrade/id/{id}")
//    public Student upgStudentID(@PathVariable Long id, @RequestBody Student student){
//        return studentService.upgradeStudentID(id, student);
//    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteStudentID(@PathVariable Long id){
        studentRepository.deleteById(id);
    }



}
