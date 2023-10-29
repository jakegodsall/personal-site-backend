package com.jakegodsall.personalsite.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ProjectDto extends BaseDto {
    private String name;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private String githubUrl;
    private String liveUrl;
}
