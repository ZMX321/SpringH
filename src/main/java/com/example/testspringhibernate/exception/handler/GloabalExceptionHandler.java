package com.example.testspringhibernate.exception.handler;


import com.example.testspringhibernate.exception.BusinessException;
import com.example.testspringhibernate.utils.BaseResponse;
import com.example.testspringhibernate.utils.ErrorCode;
import com.example.testspringhibernate.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@Slf4j
public class GloabalExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(CreateInputException.class)
//    public BaseResponse processIllegalInputException(CreateInputException exception){
//        log.error("CreateInputException: ", exception);
//        log.error("CreateInputException: ", exception.getCode());
//        return new BaseResponse<>("500", "Lack of fields.", "Input should contains at least one first name and one last name.");
//    }
//
//    @ResponseBody
//    @ExceptionHandler(NoResultException.class)
//    public BaseResponse processNoUserFoundException(NoUserFoundException exception){
//        log.error("NoUserFoundException: ", exception);
//        return new BaseResponse<>("500", "No User detected.", "Try to search with a different User Id.");
//    }

    @ResponseBody
    @ExceptionHandler
    public BaseResponse processBusinessException(BusinessException e){
        return ResultUtils.error(e.getCode() , e.getMessage(), e.getDescription());
    }

    @ResponseBody
    @ExceptionHandler
    public BaseResponse processRunTimeException(RuntimeException e){
        log.error("RuntimeException: ", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR);
    }


}
