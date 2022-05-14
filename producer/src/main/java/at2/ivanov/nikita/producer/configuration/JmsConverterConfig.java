package at2.ivanov.nikita.producer.configuration;

import at2.ivanov.nikita.producer.dto.CarRequest;
import at2.ivanov.nikita.producer.dto.CarResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmsConverterConfig {
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        //Не самый лучший подход я так понимаю, был бы рад если бы объяснили какие еще есть варианты,
        // кроме как парсить уже непосредственно в сервисе
        Map<String, Class<?>> idMap = new HashMap<>();
        idMap.put(CarRequest.class.getSimpleName(), CarRequest.class);
        idMap.put(CarResponse.class.getSimpleName(), CarResponse.class);
        converter.setTypeIdMappings(idMap);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
