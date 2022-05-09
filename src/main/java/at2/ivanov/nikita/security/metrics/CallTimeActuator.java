package at2.ivanov.nikita.security.metrics;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Endpoint(id = "time")
public class CallTimeActuator {

    @ReadOperation
    public String datetimeCall() {
        return LocalDateTime.now().toString();
    }
}
