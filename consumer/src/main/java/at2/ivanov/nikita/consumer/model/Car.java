package at2.ivanov.nikita.consumer.model;

import at2.ivanov.nikita.consumer.dto.CarDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;

    private String brandName;

    private String carNumber;

    public Car(CarDto carDto) {
        this.ownerName = carDto.getOwnerName();
        this.brandName = carDto.getBrandName();
        this.carNumber = carDto.getCarNumber();
    }
}
