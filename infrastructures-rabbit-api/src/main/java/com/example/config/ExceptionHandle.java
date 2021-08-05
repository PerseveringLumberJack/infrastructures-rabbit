package com.example.config;

import com.example.module.SecnResponse;
import com.example.toolkit.SecnException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler
    public SecnResponse handle(Exception exception){

        if(exception instanceof SecnException){
            return SecnResponse.fail(exception.getMessage());
        }else {
            return SecnResponse.fail("未知异常!");
        }
    }


}
