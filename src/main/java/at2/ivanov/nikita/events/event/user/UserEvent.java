package at2.ivanov.nikita.events.event.user;

import at2.ivanov.nikita.events.model.Product;
import at2.ivanov.nikita.events.model.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.Set;

public class UserEvent extends ApplicationEvent {
    @Getter
    private final User user;

    public UserEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
