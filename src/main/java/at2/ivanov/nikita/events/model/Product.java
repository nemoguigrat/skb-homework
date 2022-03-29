package at2.ivanov.nikita.events.model;

import at2.ivanov.nikita.events.dto.ProductDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private ProductType type;

    public Product(ProductDto productDto) {
        this.name = productDto.getName();
        this.type = productDto.getType();
    }
}
