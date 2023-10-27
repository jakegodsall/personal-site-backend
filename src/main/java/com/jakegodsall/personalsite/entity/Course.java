package com.jakegodsall.personalsite.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Course extends BaseEntity {
    private String name;
    private String author;
    private String url;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_tag",
               joinColumns = @JoinColumn(name = "course_id"),
               inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", unique = true, nullable = true)
    private Post post;
}

