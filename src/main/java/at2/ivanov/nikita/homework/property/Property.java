package at2.ivanov.nikita.homework.property;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@Getter
@ConstructorBinding
@ConfigurationProperties("homework")
@AllArgsConstructor
public class Property {
    private final String name;
    private final List<String> list;
}
