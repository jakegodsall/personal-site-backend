package com.jakegodsall.personalsite.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorityNotFoundException extends RuntimeException {
    private String authority;

    public AuthorityNotFoundException(String authority) {
        super(String.format("Authority '%s' not found.", authority));
        this.authority = authority;
    }
}
