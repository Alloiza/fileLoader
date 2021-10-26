package com.download.files.fileLoader.exception;


import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

//класс для перехватки исключений
@ControllerAdvice
@AllArgsConstructor
public class DefaultExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleException(IOException ex) {
        return ResponseEntity.badRequest().body("Возникла пробема при обработке файла");
    }
}
