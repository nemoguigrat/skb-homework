package at2.ivanov.nikita.producer.controller;

import at2.ivanov.nikita.producer.dto.CarRequest;
import at2.ivanov.nikita.producer.dto.CarResponse;
import at2.ivanov.nikita.producer.service.ProducerBrokerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import java.util.HashSet;

@RestController
@AllArgsConstructor
public class IndexController {
    private final ProducerBrokerService producerBrokerService;

    @PostMapping("/car")
    public void saveCar(@RequestBody CarRequest car) {
        producerBrokerService.saveCar(car);
    }

    @GetMapping("/car")
    public ResponseEntity<CarResponse[]> getCars() {
        return producerBrokerService.getAllCars();
    }
}
