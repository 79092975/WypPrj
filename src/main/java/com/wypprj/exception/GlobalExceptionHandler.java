package com.wypprj.exception;

import com.wypprj.result.Result;
import com.wypprj.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ConstraintViolation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Administrator
 * @DATE: 2023/10/23 11:05
 * @Description: 全局异常处理
 * @Version: 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBindGetException(ConstraintViolationException e) {
        log.error("{}", e.getMessage(), e);
        List<String> defaultMsg = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return Result.error(ResultEnum.ERROR.getCode(), defaultMsg.get(0));
    }
}
