package at2.ivanov.nikita.events.event.product;

import at2.ivanov.nikita.events.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ProductEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishProduct(Product product) {
        log.warn("Событие доавления продукта пораждается...");
        applicationEventPublisher.publishEvent(new ProductAddedEvent(this, product));
    }
}
