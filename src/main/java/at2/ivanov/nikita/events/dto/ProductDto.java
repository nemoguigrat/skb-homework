package at2.ivanov.nikita.events.dto;

import at2.ivanov.nikita.events.model.ProductType;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductDto {
    private String name;
    private ProductType type;
}
