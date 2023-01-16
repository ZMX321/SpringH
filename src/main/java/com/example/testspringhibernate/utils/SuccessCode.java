package com.example.testspringhibernate.utils;

public enum SuccessCode {

    CREATE_USER_SUCCESS("201", "ok", "User created"),
    UPDATE_SUCCESS("202", "ok", "User updated"),
    DELETE_SUCCESS("202", "ok", "User deleted");



    private final String code;

    private final String message;

    private final String description;


    SuccessCode (String code, String message, String description){
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
