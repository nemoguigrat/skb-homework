package at2.ivanov.nikita.homework.service;

import at2.ivanov.nikita.homework.property.Property;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
@EnableConfigurationProperties(Property.class)
@AllArgsConstructor
public class DataFromPropertyService {
    private final Property property;

    @PostConstruct
    public void init() {
        log.warn("Application name: " + property.getName());
        log.warn("Data from property file: " + property.getList());
    }
}
