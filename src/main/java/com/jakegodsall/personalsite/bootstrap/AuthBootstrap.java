package com.jakegodsall.personalsite.bootstrap;

import com.jakegodsall.personalsite.entity.security.Authority;
import com.jakegodsall.personalsite.entity.security.Role;
import com.jakegodsall.personalsite.entity.security.User;
import com.jakegodsall.personalsite.exceptions.RoleNotFoundException;
import com.jakegodsall.personalsite.repository.security.AuthorityRepository;
import com.jakegodsall.personalsite.repository.security.RoleRepository;
import com.jakegodsall.personalsite.repository.security.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Order(1)
@Component
public class AuthBootstrap implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (authorityRepository.count() == 0) {
            bootstrapAuthoritiesAndRoles();
            bootstrapAdminUser();
        }
    }

    private void bootstrapAuthoritiesAndRoles() {
        // Course Authorities
        Authority getCourseAuthority = Authority.builder().permission("GET_COURSE").build();
        Authority createCourseAuthority = Authority.builder().permission("CREATE_COURSE").build();
        Authority updateCourseAuthority = Authority.builder().permission("UPDATE_COURSE").build();
        Authority deleteCourseAuthority = Authority.builder().permission("DELETE_COURSE").build();

        // Post Authorities
        Authority getPostAuthority = Authority.builder().permission("GET_POST").build();
        Authority createPostAuthority = Authority.builder().permission("CREATE_POST").build();
        Authority updatePostAuthority = Authority.builder().permission("UPDATE_POST").build();
        Authority deletePostAuthority = Authority.builder().permission("DELETE_POST").build();

        // Collect Authority objects into a list
        List<Authority> authorities = new ArrayList<>(
                List.of(getCourseAuthority, createCourseAuthority, updateCourseAuthority, deleteCourseAuthority,
                        getPostAuthority, createPostAuthority, updatePostAuthority, deletePostAuthority)
        );

        // Populate the database with the authorities
        for (Authority authority : authorities) {
            authorityRepository.save(authority);
            System.out.printf("Authority '%s' saved to the database.\n", authority.getPermission());
        }

        // Create admin Role with all authorities
        Role adminRole = Role.builder().name("ADMIN").authorities(authorities).build();

        // Populate the database with the admin role
        roleRepository.save(adminRole);
        System.out.printf("Role '%s' saved to the database.\n", adminRole.getName());
    }

    private void bootstrapAdminUser() {
        // Get the ADMIN role from the database
        Role adminRole = roleRepository.findByName("ADMIN").orElseThrow(
                () -> new RoleNotFoundException("ADMIN")
        );

        // Create an admin user with the ADMIN role
        User adminUser = User.builder()
                .username("admin")
                .password("admin_password")
                .role(adminRole)
                .build();

        // Save the admin user to the database
        userRepository.save(adminUser);
        System.out.println("Admin user saved to the database.");
    }

}

