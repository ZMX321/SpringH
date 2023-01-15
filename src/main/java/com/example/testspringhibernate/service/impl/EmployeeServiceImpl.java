package com.example.testspringhibernate.service.impl;

import com.example.testspringhibernate.pojo.entity.Employee;
import com.example.testspringhibernate.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmp() {
        Query query = entityManager.createQuery("select e from Employee e");
        List<Employee> list = (List<Employee>)query.getResultList();
        return list;
    }



    @Override
    public Employee getEmpById(String id) {
        Query query = entityManager.createQuery("select e from Employee e where e.id = ?1");
        query.setParameter(1, id);
        Employee e = (Employee)query.getSingleResult();
        return e;
    }
}
