package com.enesergen.bookPortal.core.utilities.exceptionHandler;

import com.enesergen.bookPortal.core.utilities.results.ErrorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER= LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handeUsernameNotFoundException(Throwable throwable){
        LOGGER.error("Exception Message:"+throwable.getMessage());

        return new ResponseEntity<>(new ErrorResult("UsernameNotFoundException handled."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> handeSQLException(Throwable throwable){
        LOGGER.error("Exception Message:"+throwable.getMessage());

        return new ResponseEntity<>(new ErrorResult("SQLException handled."), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Throwable throwable){
        LOGGER.error("Exception Message:"+throwable.getMessage());

        return new ResponseEntity<>(new ErrorResult("Exception handled."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
