package at2.ivanov.nikita.database.service.impl;

import at2.ivanov.nikita.database.model.Event;
import at2.ivanov.nikita.database.model.TodoList;
import at2.ivanov.nikita.database.repository.TodoRepository;
import at2.ivanov.nikita.database.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplTodoService implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public void addTodoList(TodoList todoList) {
        todoList.getEvents().forEach(event -> event.setTodoList(todoList));
        todoRepository.save(todoList);
    }

    @Override
    public Iterable<TodoList> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public void addEventToTodo(Long todoId, Event event) {
        TodoList todo = todoRepository.findById(todoId).orElseThrow(IllegalArgumentException::new);
        event.setTodoList(todo);
        todo.getEvents().add(event);
        todoRepository.save(todo);
    }

    @Override
    public TodoList getTodoList(Long id) {
        return todoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
