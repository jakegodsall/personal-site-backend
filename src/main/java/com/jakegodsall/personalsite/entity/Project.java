package com.jakegodsall.personalsite.entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Project extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(name = "project_start_date", nullable = false)
    private LocalDate projectStartDate;

    @Column(name = "project_end_date", nullable = false)
    private LocalDate projectEndDate;

    private String githubUrl;

    private String liveUrl;

    @ManyToMany
    @JoinTable(name = "project_skill",
               joinColumns = @JoinColumn(name = "project_id"),
               inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills;

    @ManyToMany
    @JoinTable(name = "project_tag",
               joinColumns = @JoinColumn(name = "project_id"),
               inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @ManyToMany
    @JoinTable(name = "project_post",
               joinColumns = @JoinColumn(name = "project_id"),
               inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> posts;

}
