package com.example.exemplo.handler;

import com.example.exemplo.exception.NotFoundExDetail;
import com.example.exemplo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class NotFoundHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExDetail> handlesNotFoundEx(NotFoundException ex){
        return new ResponseEntity<>(
                NotFoundExDetail.builder()
                        .titulo("Objeto nao encontrado")
                        .status(HttpStatus.NOT_FOUND.value())
                        .msg(ex.getMessage())
                        .timeStamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }
}
