package at2.ivanov.nikita.consumer.controller;

import at2.ivanov.nikita.consumer.model.Car;
import at2.ivanov.nikita.consumer.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarController {
    private final CarRepository carRepository;

    @GetMapping("/car")
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }
}
