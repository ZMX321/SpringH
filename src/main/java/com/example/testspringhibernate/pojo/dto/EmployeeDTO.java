package com.example.testspringhibernate.pojo.dto;

import com.example.testspringhibernate.pojo.entity.Employee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {

    private String id;

    private String fistName;

    private String lastName;

    public EmployeeDTO(Employee e) {
        this.id = e.getId();
        this.fistName = e.getFirstName();
        this.lastName = e.getLastName();
    }


}
