package com.example.testspringhibernate.service;

import com.example.testspringhibernate.pojo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    List getAllStu();

    Student getStuById(String id);

    String createNewStudent(Student s);

    void updateStuInfo(Student s);

    void deleteStuById(String id);
}
