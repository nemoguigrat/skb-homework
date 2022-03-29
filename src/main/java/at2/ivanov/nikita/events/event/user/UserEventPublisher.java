package at2.ivanov.nikita.events.event.user;

import at2.ivanov.nikita.events.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class UserEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishUser(User user) {
        log.warn("Событие пользователя пораждается...");
        applicationEventPublisher.publishEvent(new UserEvent(this, user));
    }
}
