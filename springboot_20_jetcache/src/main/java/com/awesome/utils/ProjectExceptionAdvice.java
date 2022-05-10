package com.awesome.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    // intercept all exception information
    @ExceptionHandler
    public R doException(Exception e){
        e.printStackTrace();
        return new R("Server failure, please try again later!");
    }
}
