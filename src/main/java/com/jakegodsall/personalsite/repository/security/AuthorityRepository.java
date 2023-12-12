package com.jakegodsall.personalsite.repository.security;

import com.jakegodsall.personalsite.entity.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
