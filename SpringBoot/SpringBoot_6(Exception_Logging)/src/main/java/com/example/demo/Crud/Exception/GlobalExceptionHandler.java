package com.example.demo.Crud.Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(Exception exception){
        logger.error("Error when Finding User",exception);
        Map<String,Object> errorResponse=new HashMap<>();
        errorResponse.put("message",exception.getMessage());
        errorResponse.put("timeStamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error","Bhaiya bat bigad gyi");
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String,Object>>HandleIllegalMethodException(Exception exception){
        Map<String,Object> errorResponse=new HashMap<>();
        errorResponse.put("message",exception.getMessage());
        errorResponse.put("error","Bhaiya method Dekh lo konsa use kr rhe ho");
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,Object>>UserNotFound(Exception exception){
        Map<String,Object> errorResponse=new HashMap<>();
        errorResponse.put("message",exception.getMessage());
        errorResponse.put("error","Bhaiya user hai hi nhi ye");
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }




}
