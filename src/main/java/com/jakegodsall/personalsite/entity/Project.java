package com.jakegodsall.personalsite.entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "project")
public class Project extends BaseEntity {

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(name = "project_start_date", nullable = false)
    private LocalDate projectStartDate;

    @NotNull
    @Column(name = "project_end_date", nullable = false)
    private LocalDate projectEndDate;

    @Size(max = 100)
    @Column(length = 100)
    private String githubUrl;

    @Size(max = 100)
    @Column(length = 100)
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
