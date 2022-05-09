package at2.ivanov.nikita.security.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserActiveSessionsMetric {
    private final AtomicInteger userSessionsOnline;
    private final SessionRegistry sessionRegistry;

    public UserActiveSessionsMetric(MeterRegistry registry, SessionRegistry sessionRegistry) {
        this.userSessionsOnline = registry.gauge("user.online.sessions", new AtomicInteger(0));
        this.sessionRegistry = sessionRegistry;
    }

    // можно было сделать на слушателях ивентов, что бы в холостую не работал метод, но так проще
    @Scheduled(fixedRate=10000)
    public void checkActiveUsers() {
        userSessionsOnline.set(sessionRegistry.getAllPrincipals().size());
    }
}
