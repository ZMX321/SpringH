package com.example.testspringhibernate.utils;

public class ResultUtils {

    public static <T> BaseResponse<T> success(T data){
        return new BaseResponse<>("200", data, "ok");
    }

    public static BaseResponse success(SuccessCode sc){
        return new BaseResponse(sc);
    }

    public static BaseResponse error(String code, String messgae, String description){
        return new BaseResponse(code, null, messgae, description);
    }

    public static BaseResponse error(ErrorCode er){
        return new BaseResponse(er);
    }




}
