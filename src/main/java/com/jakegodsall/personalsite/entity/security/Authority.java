package com.jakegodsall.personalsite.entity.security;

import com.jakegodsall.personalsite.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "authority")
public class Authority extends BaseEntity {

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String permission;

    @Override
    public String toString() {
        return permission;
    }
}
