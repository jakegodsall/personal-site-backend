package com.jakegodsall.personalsite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "skill")
public class Skill extends BaseEntity {

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Project> projects;

    @ManyToMany(mappedBy = "skills")
    private Set<Course> courses;

    @ManyToMany(mappedBy = "skills")
    private Set<Post> posts;


}
