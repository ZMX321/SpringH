package com.example.testspringhibernate.utils;

public enum ErrorCode {

    NULL_ERROR("404", "No user found", "try to operate with a different user id"),
    WRONG_TYPE("400", "Lack of field", "firstname and lastname is required for a new user"),
    SYSTEM_ERROR("500", "Internal system error", "");



    private final String code;

    private final String message;

    private final String description;


    ErrorCode (String code, String message, String description){
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
