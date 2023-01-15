package com.example.testspringhibernate.pojo.dto;

import com.example.testspringhibernate.pojo.entity.Student;
import lombok.Data;

@Data
public class StudentDTO {

    private String id;

    private String fistName;

    private String lastName;

    public StudentDTO(Student e) {
        this.id = e.getId();
        this.fistName = e.getFirstName();
        this.lastName = e.getLastName();
    }


}
