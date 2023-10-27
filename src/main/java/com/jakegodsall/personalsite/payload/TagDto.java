package com.jakegodsall.personalsite.payload;

import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class TagDto {
    private Long id;
    private LocalDateTime lastModifiedDate;
    private LocalDateTime createdDate;
    private String name;
}
