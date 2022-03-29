package at2.ivanov.nikita.events.event.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@AllArgsConstructor
@Slf4j
public class UserEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleAddUser(UserEvent userEvent) {
        log.warn("Событие для пользователя с подписками...");
        log.warn("Пользователь подписан.");
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleWrongUser(UserEvent userEvent) {
        log.warn("Событие для пользователя без подписок...");
        log.warn("Пользователь без подписок.");
    }
}
