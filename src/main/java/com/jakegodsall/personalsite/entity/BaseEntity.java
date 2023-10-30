package com.jakegodsall.personalsite.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @LastModifiedDate
    @Column(name = "last_modified_date", nullable = false, updatable = false, insertable = false)
    private LocalDateTime lastModifiedDate;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdDate;

}
