package com.jakegodsall.personalsite.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class PostDto {
    private Long id;
    private LocalDateTime lastModifiedDate;
    private LocalDateTime createdDate;
    private String title;
    private String description;
    private String content;
}
