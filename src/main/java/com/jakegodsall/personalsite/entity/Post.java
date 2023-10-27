package com.jakegodsall.personalsite.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Post extends BaseEntity {
    private String title;
    private String description;
    private String content;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_tag",
               joinColumns = @JoinColumn(name = "post_id"),
               inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();
    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
    private Course course;
}
