package at2.ivanov.nikita.database.controller;

import at2.ivanov.nikita.database.model.Event;
import at2.ivanov.nikita.database.model.TodoList;
import at2.ivanov.nikita.database.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Set;

@Validated
@RestController
@AllArgsConstructor
public class TodoController {
    @Qualifier("implTodoService")
    private final TodoService todoService;

    @PostMapping("/todos")
    public void addTodoList(@Valid @RequestBody TodoList todoList) {
        todoService.addTodoList(todoList);
    }

    @GetMapping("/todos")
    public Iterable<TodoList> getTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping("/todos/{id}")
    public void addEvent(@PathVariable @Min(1) Long id, @Valid @RequestBody Event event) {
        todoService.addEventToTodo(id, event);
    }

    @GetMapping("/todos/{id}")
    public TodoList getTodo(@PathVariable @Min(1) Long id) {
        return todoService.getTodoList(id);
    }
 }
