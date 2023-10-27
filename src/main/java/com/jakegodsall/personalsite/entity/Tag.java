package com.jakegodsall.personalsite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Tag extends BaseEntity {
    private String name;
    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts = new HashSet<>();
    @ManyToMany(mappedBy = "tags")
    private Set<Course> courses = new HashSet<>();
}
