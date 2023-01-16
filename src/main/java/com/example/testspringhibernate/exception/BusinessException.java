package com.example.testspringhibernate.exception;

import com.example.testspringhibernate.utils.ErrorCode;

public class BusinessException extends RuntimeException{

    private final String code;

    private final String description;

    public BusinessException(String code, String message, String description){
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(ErrorCode er){
        super(er.getMessage());
        this.code = er.getCode();
        this.description = er.getDescription();
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
