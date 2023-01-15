package com.example.testspringhibernate.controller;


import com.example.testspringhibernate.TestSpringHibernateApplication;
import com.example.testspringhibernate.pojo.dto.EmployeeDTO;
import com.example.testspringhibernate.pojo.entity.Employee;
import com.example.testspringhibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmp(){
        List<Employee> list = employeeService.getAllEmp();

        return list.stream().map(e -> new EmployeeDTO(e))
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public EmployeeDTO getEmpById(@PathVariable String id){
        Employee e = employeeService.getEmpById(id);
        return new EmployeeDTO(e);
    }


}
