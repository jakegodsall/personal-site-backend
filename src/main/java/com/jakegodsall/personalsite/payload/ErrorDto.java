package com.jakegodsall.personalsite.payload;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ErrorDto {
    private String message;
    private LocalDateTime dateTime;

    public ErrorDto(String message) {
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }
}
