package com.example.testspringhibernate.service;

import com.example.testspringhibernate.pojo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {

    List getAllEmp();

    Employee getEmpById(String id);

    String insertToEmployee(Employee e);
}
