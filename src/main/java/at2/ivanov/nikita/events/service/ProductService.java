package at2.ivanov.nikita.events.service;

import at2.ivanov.nikita.events.dto.ProductDto;
import at2.ivanov.nikita.events.event.product.ProductEventPublisher;
import at2.ivanov.nikita.events.model.Product;
import at2.ivanov.nikita.events.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductEventPublisher productEventPublisher;

    public void addProduct(ProductDto productDto) {
        Product product = productRepository.save(new Product(productDto));
        productEventPublisher.publishProduct(product);
    }
}
