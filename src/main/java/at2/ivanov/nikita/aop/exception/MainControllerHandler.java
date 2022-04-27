package at2.ivanov.nikita.aop.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MainControllerHandler {
    @ExceptionHandler(MaxMethodCallsException.class)
    public String handleMaxMethodCalls(RuntimeException exception) {
        return exception.getMessage();
    }
}
