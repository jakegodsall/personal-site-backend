package com.jakegodsall.personalsite.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class PostDto extends BaseDto {
    private String title;
    private String description;
    private String content;
}
