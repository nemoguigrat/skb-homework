package at2.ivanov.nikita.events.service;

import at2.ivanov.nikita.events.dto.UserDto;
import at2.ivanov.nikita.events.event.user.UserEvent;
import at2.ivanov.nikita.events.event.user.UserEventPublisher;
import at2.ivanov.nikita.events.model.User;
import at2.ivanov.nikita.events.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserEventPublisher userEventPublisher;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addUser(UserDto userDto) {
        User user = new User(userDto);
        userEventPublisher.publishUser(user);
        if (user.getSubscribeTypes().size() == 0)
            throw new IllegalArgumentException(); // да по варварски, ничего больше не придумал, зато работает
        userRepository.save(user);
    }
}
