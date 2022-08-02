package com.enesergen.obss.springStarter.springStarter.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.util.HashMap;

@ControllerAdvice
public class GlobalExcepitonHandler {
    private static final Logger LOGGER= LoggerFactory.getLogger(GlobalExcepitonHandler.class);


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>handleValidationException(HttpServletRequest request, HttpServletResponse response,MethodArgumentNotValidException e){
        LOGGER.error(e.getMessage(),e);
        var map=new HashMap<>();
        map.put("Error",e.getMessage());
        return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>HandleRuntimeException(Throwable throwable){
        LOGGER.error(throwable.getMessage(),throwable);
        var map=new HashMap<>();
        map.put("Error","UnKnown Error Occured");
        return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
