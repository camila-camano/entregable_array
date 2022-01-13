package com.example.arrayproducts.handle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorMessageHandle{

    Logger logger = LogManager.getLogger(ErrorMessageHandle.class);

    @ResponseBody
    @ExceptionHandler(ProductoError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage messageErrorHandle(ProductoError ex) {

        return new ErrorMessage(ex.getMessage());

    }
}
