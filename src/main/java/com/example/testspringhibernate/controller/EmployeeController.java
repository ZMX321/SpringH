package com.example.testspringhibernate.controller;


import com.example.testspringhibernate.TestSpringHibernateApplication;
import com.example.testspringhibernate.pojo.dto.EmployeeDTO;
import com.example.testspringhibernate.pojo.entity.Employee;
import com.example.testspringhibernate.service.EmployeeService;
import com.example.testspringhibernate.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
@Slf4j
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
    public BaseResponse getEmpById(@PathVariable String id){
        Employee e = employeeService.getEmpById(id);
        return new BaseResponse(HttpStatus.OK, new EmployeeDTO(e), "Employee found.") ;
    }

    @PostMapping
    public BaseResponse createNewEmp(@RequestBody Employee e){
        log.info(e.toString());

        String newId = employeeService.insertToEmployee(e);
        return new BaseResponse(HttpStatus.OK, null, "Success add a new employee!", "The new employee id is " + newId);
    }




}
