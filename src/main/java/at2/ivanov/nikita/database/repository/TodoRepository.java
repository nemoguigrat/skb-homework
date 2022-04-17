package at2.ivanov.nikita.database.repository;

import at2.ivanov.nikita.database.model.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoList, Long> {
}
