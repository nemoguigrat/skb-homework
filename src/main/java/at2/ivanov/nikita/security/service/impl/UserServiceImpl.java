package at2.ivanov.nikita.security.service.impl;

import at2.ivanov.nikita.security.dto.RegisterDto;
import at2.ivanov.nikita.security.dto.UserDto;
import at2.ivanov.nikita.security.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final InMemoryUserDetailsManager userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private static final String ROLE_PREFIX = "ROLE_";

    @Override
    public UserDto getUser(Principal principal) {
        return new UserDto(userDetailsService.loadUserByUsername(principal.getName()));
    }

    @Override
    public void registerUser(RegisterDto register) {
        if (userDetailsService.userExists(register.getUsername()))
            throw new IllegalArgumentException();
        UserDetails user = User.withUsername(register.getUsername())
                .password(passwordEncoder.encode(register.getPassword()))
                .roles("USER").build();
        userDetailsService.createUser(user);
    }

    @Override
    public void addUserRole(String username, String role) {
        UserDetails user = userDetailsService.loadUserByUsername(username);
        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        roles.add(ROLE_PREFIX + role.toUpperCase());
        userDetailsService.updateUser(User.withUserDetails(user)
                .authorities(roles.toArray(new String[user.getAuthorities().size() + 1])).build());
    }
}
