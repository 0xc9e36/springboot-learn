package pers.tan.springbootlearnweb.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = NullPointerException.class)
    public String defaultErrorHandler(HttpServletRequest req, NullPointerException e) throws Exception {
        return "空指针异常";
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public String defaultErrorHandler(HttpServletRequest req, IllegalArgumentException e) throws Exception {
        return "参数异常";
    }
}

