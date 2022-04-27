package at2.ivanov.nikita.aop.exception;

public class MaxMethodCallsException extends RuntimeException {
    public MaxMethodCallsException(String message) {
        super(message);
    }
}
