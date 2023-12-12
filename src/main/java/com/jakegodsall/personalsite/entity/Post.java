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
@Table(name = "post")
public class Post extends BaseEntity {

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String title;

    @Size(max = 100)
    @NotNull
    @Column(length = 100, nullable = false)
    private String description;

    @Column(nullable = false)
    private String content;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_tag",
               joinColumns = @JoinColumn(name = "post_id"),
               inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
    private Course course;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "post_skill",
               joinColumns = @JoinColumn(name = "post_id"),
               inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills;
}
