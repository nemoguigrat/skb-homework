package at2.ivanov.nikita.database.service.impl;

import at2.ivanov.nikita.database.model.Event;
import at2.ivanov.nikita.database.repository.EventRepository;
import at2.ivanov.nikita.database.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplEventService implements EventService {
    private final EventRepository eventRepository;

    @Override
    public Event getEvent(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void changeEvent(Long eventId, Boolean isDone) {
        Event event = eventRepository.findById(eventId).orElseThrow(IllegalArgumentException::new);
        event.setDone(isDone);
        eventRepository.save(event);
    }
}
