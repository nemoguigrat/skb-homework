package at2.ivanov.nikita.database.repository;

import at2.ivanov.nikita.database.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}
