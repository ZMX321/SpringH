package com.example.testspringhibernate.service.impl;

import com.example.testspringhibernate.pojo.entity.Employee;
import com.example.testspringhibernate.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
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

    public Employee getByName(String firstName, String lastName){
        Query query = entityManager.createQuery("select e from Employee e where e.firstName = ?1 AND e.lastName = ?2");
        query.setParameter(1, firstName);
        query.setParameter(2, lastName);
        Employee e = (Employee) query.getSingleResult();

        return e;
    }


    @Override
    @Transactional
    public String insertToEmployee(Employee e) {

        Employee toBeInsert = new Employee();
        toBeInsert.setFirstName(e.getFirstName());
        toBeInsert.setLastName(e.getLastName());
        toBeInsert.setGender(e.getGender());
        toBeInsert.setIsAdmin(e.getIsAdmin());
        toBeInsert.setCreateTime(new Date());
        toBeInsert.setUpdateTime(new Date());


        entityManager.persist(toBeInsert);



        return toBeInsert.getId();
    }
}
