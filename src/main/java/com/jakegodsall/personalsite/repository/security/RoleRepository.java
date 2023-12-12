package com.jakegodsall.personalsite.repository.security;

import com.jakegodsall.personalsite.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
