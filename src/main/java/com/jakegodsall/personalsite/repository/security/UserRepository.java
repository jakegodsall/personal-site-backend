package com.jakegodsall.personalsite.repository.security;

import com.jakegodsall.personalsite.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
