package com.agussuhardi.springvalidation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author agus.suhardii@gmail.com
 * @created 13/06/23/06/2023 :21.25
 * @project spring-validation
 */
@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> handleNoHandlerFound(NoHandlerFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException ex) {
        Map<String, List<String>> map = new HashMap<>();
        for (final var error : ex.getBindingResult().getFieldErrors()) {
            List<String> msgs = new ArrayList<>();
            if (map.containsKey(error.getField())) msgs = map.get(error.getField());
            msgs.add(error.getDefaultMessage());
            map.put(error.getField(), msgs);
        }

        for (final var error : ex.getBindingResult().getGlobalErrors()) {
            List<String> msgs = new ArrayList<>();
            if (map.containsKey(error.getObjectName())) msgs = map.get(error.getObjectName());
            msgs.add(error.getDefaultMessage());
            map.put(error.getObjectName(), msgs);
        }
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}
