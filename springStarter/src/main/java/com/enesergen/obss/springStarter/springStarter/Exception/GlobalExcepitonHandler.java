package com.enesergen.obss.springStarter.springStarter.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExcepitonHandler {
    private static final Logger LOGGER= LoggerFactory.getLogger(GlobalExcepitonHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>HandleRuntimeException(Throwable throwable){
        LOGGER.error(throwable.getMessage(),throwable);
        var map=new HashMap<>();
        map.put("Error","UnKnown Error Occured");
        return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
