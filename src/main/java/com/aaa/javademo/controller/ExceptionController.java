package com.aaa.javademo.controller;

import com.aaa.javademo.common.AppException;
import com.aaa.javademo.common.Result;
import com.aaa.javademo.util.ThreadParam;
import com.aaa.javademo.util.Watch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(value = Exception.class)
    public Result<String> exception(Exception e) {
        Watch w = ThreadParam.get();
        log.error(w.getId(), e);
        Result<String> rs = new Result<>();
        rs.setSuccess(false);
        rs.setData("未知错误，请联系管理员");
        return rs;
    }

    @ExceptionHandler(value = AppException.class)
    public Result<String> appException(AppException e) {
        Result<String> rs = new Result<>();
        rs.setSuccess(false);
        rs.setData(e.getMessage());
        return rs;
    }

}
