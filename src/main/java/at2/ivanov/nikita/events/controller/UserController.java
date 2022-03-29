package at2.ivanov.nikita.events.controller;

import at2.ivanov.nikita.events.dto.UserDto;
import at2.ivanov.nikita.events.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }
}
