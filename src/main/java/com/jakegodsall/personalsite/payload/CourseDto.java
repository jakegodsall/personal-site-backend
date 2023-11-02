package com.jakegodsall.personalsite.payload;

import lombok.*;


@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class CourseDto extends BaseDto {
    private String name;
    private String author;
    private String url;
}
