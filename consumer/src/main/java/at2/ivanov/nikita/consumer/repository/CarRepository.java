package at2.ivanov.nikita.consumer.repository;

import at2.ivanov.nikita.consumer.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}
