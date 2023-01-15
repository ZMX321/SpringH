package com.example.testspringhibernate.controller;


import com.example.testspringhibernate.pojo.dto.StudentDTO;
import com.example.testspringhibernate.pojo.entity.Student;
import com.example.testspringhibernate.service.StudentService;
import com.example.testspringhibernate.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStu(){
        List<Student> list = studentService.getAllStu();

        return list.stream().map(e -> new StudentDTO(e))
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public BaseResponse getStuById(@PathVariable String id){
        Student e = studentService.getStuById(id);
        return new BaseResponse(HttpStatus.OK, new StudentDTO(e), "Student found.") ;
    }

    @PostMapping
    public BaseResponse createNewStu(@RequestBody Student s){
        log.info(s.toString());

        String newId = studentService.createNewStudent(s);
        return new BaseResponse(HttpStatus.OK, null, "Success add a new student!", "The new employee id is " + newId);
    }

    @PatchMapping
    public BaseResponse udpateStuInfo(@RequestBody Student s){
        studentService.updateStuInfo(s);
        return new BaseResponse(HttpStatus.OK, null, "Success update the student information!");
    }




}
