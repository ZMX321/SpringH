package com.example.testspringhibernate.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {

    private HttpStatus code;

    private  T data;

    private String message;

    private String description;

    public BaseResponse(HttpStatus code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(HttpStatus code, T data, String message){
        this(code, data, message, "");
    }

    public BaseResponse(HttpStatus code, String message){
        this(code, null, message, "");
    }



}
