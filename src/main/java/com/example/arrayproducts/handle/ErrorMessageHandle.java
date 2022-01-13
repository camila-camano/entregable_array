package com.example.arrayproducts.handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorMessageHandle{

    @ResponseBody
    @ExceptionHandler(ProductoError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage messageErrorHandle(ProductoError ex) {
        return new ErrorMessage(ex.getMessage());
    }
}
