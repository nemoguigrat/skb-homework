package at2.ivanov.nikita.security.controller;

import at2.ivanov.nikita.security.dto.RegisterDto;
import at2.ivanov.nikita.security.dto.UserDto;
import at2.ivanov.nikita.security.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/public/register")
    public void register(@RequestBody RegisterDto data) {
        userService.registerUser(data);
    }

    @GetMapping("/api/secured/user")
    public UserDto getUser(Principal principal) {
        return userService.getUser(principal);
    }

    @PostMapping("/api/admin/role")
    public void setRole(@RequestParam String username, @RequestParam String role) {
        userService.addUserRole(username, role);
    }

    @GetMapping("/api/support/support-info")
    public String getSupportInfo() {
        return "Some support info";
    }
}