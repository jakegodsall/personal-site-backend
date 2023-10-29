package com.jakegodsall.personalsite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Skill extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Project> projects;

    @ManyToMany(mappedBy = "skills")
    private Set<Course> courses;

    @ManyToMany(mappedBy = "skills")
    private Set<Post> posts;


}
