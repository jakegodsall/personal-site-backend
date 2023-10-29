package com.jakegodsall.personalsite.payload;

import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class TagDto extends BaseDto {
    private String name;
}
