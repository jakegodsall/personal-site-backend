package com.jakegodsall.personalsite.payload;

import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class TagDto extends BaseDto {
    private String name;
    @Override
    public String toString() {
        return "Id: " + this.getId() + "\n" +
                "Created Date: " + this.getCreatedDate() + "\n" +
                "Last Modified Date: " + this.getLastModifiedDate() + "\n" +
                "Name: " + this.getName();

    }
}
