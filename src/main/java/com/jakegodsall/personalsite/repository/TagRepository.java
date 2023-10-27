package com.jakegodsall.personalsite.repository;

import com.jakegodsall.personalsite.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
