package com.example.demo.exception;

import com.example.demo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<Object> exceptionHandler(Exception e){
        log.error(e.getMessage(),e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<Object> runtimeExceptionHandler(RuntimeException e){
        log.error(e.getMessage(),e);
        return Result.error(e.getMessage());
    }
}
