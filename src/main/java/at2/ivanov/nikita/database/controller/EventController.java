package at2.ivanov.nikita.database.controller;

import at2.ivanov.nikita.database.model.Event;
import at2.ivanov.nikita.database.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
@AllArgsConstructor
public class EventController {
    @Qualifier("implEventService")
    private final EventService eventService;

    @PatchMapping("/event/{eventId}")
    public void changeEvent(@PathVariable @Min(1) Long eventId, @RequestParam Boolean isDone) {
        eventService.changeEvent(eventId, isDone);
    }

    @GetMapping("/event/{eventId}")
    public Event getEvent(@PathVariable @Min(1) Long eventId) {
        return eventService.getEvent(eventId);
    }
}
