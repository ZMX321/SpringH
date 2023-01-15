package com.example.testspringhibernate.service.impl;

import com.example.testspringhibernate.pojo.entity.Student;
import com.example.testspringhibernate.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStu() {
        Query query = entityManager.createQuery("select s from Student s");
        List<Student> list = (List<Student>)query.getResultList();
        return list;
    }



    @Override
    public Student getStuById(String id) {
        Query query = entityManager.createQuery("select s from Student s where s.id = ?1");
        query.setParameter(1, id);
        Student e = (Student)query.getSingleResult();
        return e;
    }

    public Student getByName(String firstName, String lastName){
        Query query = entityManager.createQuery("select s from Student s where s.firstName = ?1 AND s.lastName = ?2");
        query.setParameter(1, firstName);
        query.setParameter(2, lastName);
        Student e = (Student) query.getSingleResult();

        return e;
    }


    @Override
    @Transactional
    public String createNewStudent(Student e) {

        Student toBeInsert = new Student();
        toBeInsert.setFirstName(e.getFirstName());
        toBeInsert.setLastName(e.getLastName());
        toBeInsert.setGender(e.getGender());
        toBeInsert.setIsActive("1");
        toBeInsert.setIsDelete("0");
        toBeInsert.setCreateTime(new Date());
        toBeInsert.setUpdateTime(new Date());


        entityManager.persist(toBeInsert);



        return toBeInsert.getId();
    }
}
