package com.example.exemplo.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class NotFoundExDetail {
    private String titulo;
    private String msg;
    private int status;
    private LocalDateTime timeStamp;


}
