package at2.ivanov.nikita.events.controller;

import at2.ivanov.nikita.events.dto.ProductDto;
import at2.ivanov.nikita.events.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }
}
