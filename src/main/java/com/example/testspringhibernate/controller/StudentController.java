package com.example.testspringhibernate.controller;


import com.example.testspringhibernate.exception.BusinessException;
import com.example.testspringhibernate.pojo.dto.StudentDTO;
import com.example.testspringhibernate.pojo.entity.Student;
import com.example.testspringhibernate.service.StudentService;
import com.example.testspringhibernate.utils.BaseResponse;
import com.example.testspringhibernate.utils.ErrorCode;
import com.example.testspringhibernate.utils.ResultUtils;
import com.example.testspringhibernate.utils.SuccessCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public BaseResponse getAllStu(){
        List<Student> list = studentService.getAllStu();

        List<StudentDTO> studentDTOS = list.stream().map(e -> new StudentDTO(e))
                .collect(Collectors.toList());


        return ResultUtils.success(studentDTOS);
    }

    @GetMapping("/{id}")
    public BaseResponse getStuById(@PathVariable String id){
        Student s = studentService.getStuById(id);

        return ResultUtils.success(new StudentDTO(s)) ;
    }

    @PostMapping
    public BaseResponse createNewStu(@RequestBody Student s){
        if(s.getFirstName() == null || s.getLastName() == null){
            throw new BusinessException(ErrorCode.WRONG_TYPE);
        }
        log.info(s.toString());

//      log.info(studentService.createNewStudent(s));
        return ResultUtils.success(SuccessCode.CREATE_USER_SUCCESS);
    }

    @PatchMapping
    public BaseResponse udpateStuInfo(@RequestBody Student s){
        studentService.updateStuInfo(s);
        return ResultUtils.success(SuccessCode.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteStu(@PathVariable String id){
        studentService.deleteStuById(id);

        return ResultUtils.success(SuccessCode.DELETE_SUCCESS);
    }





}
