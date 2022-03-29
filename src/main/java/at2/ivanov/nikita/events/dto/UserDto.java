package at2.ivanov.nikita.events.dto;

import at2.ivanov.nikita.events.model.ProductType;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class UserDto {
    private String name;
    private String email;
    private Set<ProductType> subscribeTypes;
}
