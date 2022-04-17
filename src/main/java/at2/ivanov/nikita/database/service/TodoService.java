package at2.ivanov.nikita.database.service;

import at2.ivanov.nikita.database.model.Event;
import at2.ivanov.nikita.database.model.TodoList;

public interface TodoService {
    void addTodoList(TodoList todoList);

    Iterable<TodoList> getAllTodos();

    void addEventToTodo(Long todoId, Event event);

    TodoList getTodoList(Long id);
}
