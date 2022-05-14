package at2.ivanov.nikita.producer.service;

import at2.ivanov.nikita.producer.dto.CarRequest;
import at2.ivanov.nikita.producer.dto.CarResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.jms.JMSException;
import javax.jms.Message;

@Service
@Slf4j
@AllArgsConstructor
public class ProducerBrokerService {
    private final JmsTemplate jmsTemplate;
    private final RestTemplate restTemplate = new RestTemplate();

    public void saveCar(CarRequest message) {
        jmsTemplate.convertAndSend("cars.post", message);
    }

    public ResponseEntity<CarResponse[]> getAllCars() {
        return restTemplate.getForEntity("http://localhost:8081/car", CarResponse[].class); //eureka
    }
}
