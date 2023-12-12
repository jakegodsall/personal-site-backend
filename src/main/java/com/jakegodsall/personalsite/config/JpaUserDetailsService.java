package com.jakegodsall.personalsite.config;

import com.jakegodsall.personalsite.entity.security.Authority;
import com.jakegodsall.personalsite.entity.security.User;
import com.jakegodsall.personalsite.repository.security.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username)
        );

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(mapEntityAuthoritiesToGrantedAuthorities(user.getAuthorities()))
                .accountExpired(!user.getIsAccountNonExpired())
                .accountLocked(!user.getIsAccountNonLocked())
                .credentialsExpired(!user.getIsCredentialsNonExpired())
                .build();
    }

    private Collection<? extends GrantedAuthority> mapEntityAuthoritiesToGrantedAuthorities(Set<Authority> authorities) {
        if (authorities != null && !authorities.isEmpty()) {
            return authorities.stream()
                    .map(Authority::getPermission)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toSet());
        } else {
            return new HashSet<>();
        }
    }
}
