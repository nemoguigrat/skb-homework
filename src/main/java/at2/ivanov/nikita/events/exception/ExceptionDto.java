package at2.ivanov.nikita.events.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ExceptionDto {
    private final HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;
    private final String message;
    private final String exceptionClass;

    public ExceptionDto(HttpStatus status, RuntimeException ex) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = ex.getMessage();
        this.exceptionClass = ex.getClass().getName();
    }
}
