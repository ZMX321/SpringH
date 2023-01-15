package com.example.testspringhibernate.controller;


import com.example.testspringhibernate.TestSpringHibernateApplication;
import com.example.testspringhibernate.pojo.entity.Employee;
import com.example.testspringhibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmp(){
        return employeeService.getAllEmp();
    }


    @GetMapping("/{id}")
    public Employee getEmpById(@PathVariable String id){
        return employeeService.getEmpById(id);
    }


}
