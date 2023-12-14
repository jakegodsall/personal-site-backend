package com.jakegodsall.personalsite.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleNotFoundException extends RuntimeException {
    private String role;

    public RoleNotFoundException(String role) {
        super(String.format("Role '%s' not found.", role));
        this.role = role;
    }
}
