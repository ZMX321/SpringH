package com.example.testspringhibernate.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {

    private String code;

    private  T data;

    private String message;

    private String description;

    public BaseResponse(){}

    public BaseResponse(String code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(String code, T data, String message){
        this(code, data, message, "");
    }


    public BaseResponse(ErrorCode er){
        this.code = er.getCode();
        this.message = er.getMessage();
        this.description = er.getDescription();
    }
    public BaseResponse(SuccessCode sc){
        this.code = sc.getCode();
        this.message = sc.getMessage();
        this.description = sc.getDescription();
    }



}
