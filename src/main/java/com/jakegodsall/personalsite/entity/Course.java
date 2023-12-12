package com.jakegodsall.personalsite.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "course")
public class Course extends BaseEntity {

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String name;

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String author;

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String url;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "course_skill",
               joinColumns = @JoinColumn(name = "course_id"),
               inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_tag",
               joinColumns = @JoinColumn(name = "course_id"),
               inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", unique = true, nullable = true)
    private Post post;
}

