package com.jakegodsall.personalsite.bootstrap;

import com.jakegodsall.personalsite.entity.security.Authority;
import com.jakegodsall.personalsite.entity.security.Role;
import com.jakegodsall.personalsite.repository.security.AuthorityRepository;
import com.jakegodsall.personalsite.repository.security.RoleRepository;
import com.jakegodsall.personalsite.repository.security.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {
        if (authorityRepository.count() == 0)
            bootstrapAuthoritiesAndRoles();
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

        List<Authority> authorities = new ArrayList<>(
                List.of(getCourseAuthority, createCourseAuthority, updateCourseAuthority, deleteCourseAuthority,
                        getPostAuthority, createPostAuthority, updatePostAuthority, deletePostAuthority)
        );

        for (Authority authority : authorities) {
            authorityRepository.save(authority);
            System.out.printf("Authority '%s' saved to the database.\n", authority.getPermission());
        }


    }
}

