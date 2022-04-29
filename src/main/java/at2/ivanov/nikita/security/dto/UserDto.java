package at2.ivanov.nikita.security.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDto {
    private String name;
    private Set<String> authority;

    public UserDto(UserDetails userDetails) {
        this.name = userDetails.getUsername();
        this.authority = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
    }
}
