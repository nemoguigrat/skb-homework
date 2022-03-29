package at2.ivanov.nikita.events.event.product;

import at2.ivanov.nikita.events.model.Product;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class ProductAddedEvent extends ApplicationEvent {
    @Getter
    private final Product product;

    public ProductAddedEvent(Object source, Product product) {
        super(source);
        this.product = product;
    }
}
