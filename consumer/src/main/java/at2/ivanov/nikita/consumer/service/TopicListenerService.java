package at2.ivanov.nikita.consumer.service;

import at2.ivanov.nikita.consumer.dto.CarDto;
import at2.ivanov.nikita.consumer.model.Car;
import at2.ivanov.nikita.consumer.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TopicListenerService {
    private final CarRepository carRepository;

    @JmsListener(destination = "cars.post")
    public void receiveSaveCars(CarDto carDto) {
        log.error(carDto.toString());
        carRepository.save(new Car(carDto));
    }
}
