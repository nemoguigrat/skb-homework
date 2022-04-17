package at2.ivanov.nikita.database.service;

import at2.ivanov.nikita.database.model.Event;
import org.springframework.stereotype.Service;

public interface EventService {
    Event getEvent(Long eventId);

    void changeEvent(Long eventId, Boolean isDone);
}
