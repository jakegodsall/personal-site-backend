package com.jakegodsall.personalsite.payload;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BaseDto {
    private Long id;
    private LocalDateTime lastModifiedDate;
    private LocalDateTime createdDate;
}
