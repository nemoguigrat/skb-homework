package at2.ivanov.nikita.security.service;

import at2.ivanov.nikita.security.dto.RegisterDto;
import at2.ivanov.nikita.security.dto.UserDto;

import java.security.Principal;

public interface UserService {
    UserDto getUser(Principal principal);

    void registerUser(RegisterDto register);

    void addUserRole(String username, String role);
}
