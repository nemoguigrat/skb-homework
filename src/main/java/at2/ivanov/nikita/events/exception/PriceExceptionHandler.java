package at2.ivanov.nikita.events.exception;

import at2.ivanov.nikita.events.dto.PriceDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PriceExceptionHandler{
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ExceptionDto handleHttpNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
        return new ExceptionDto(HttpStatus.BAD_GATEWAY, ex);
    }
}
