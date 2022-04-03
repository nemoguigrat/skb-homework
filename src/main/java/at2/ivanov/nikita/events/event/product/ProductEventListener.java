package at2.ivanov.nikita.events.event.product;

import at2.ivanov.nikita.events.model.Product;
import at2.ivanov.nikita.events.model.User;
import at2.ivanov.nikita.events.repository.UserRepository;
import at2.ivanov.nikita.events.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ProductEventListener {
    private final UserRepository userRepository;
    private final EmailService emailService;

    @Async
    @EventListener
    public void handleProductAdding(ProductAddedEvent productEvent) {
        log.warn("Начало обработки события добавления продукта...");
        Product product = productEvent.getProduct();
        String text = "Появился новый продукт " + product.getName() + " заглядвыйте скорее!";
        Set<User> users = userRepository.findUsersBySubscribeTypesContaining(product.getType());
        emailService.sendMessages(users, "Появился новый продукт", text);
        log.warn("Событие добавления продукта обработано...");
    }
}
