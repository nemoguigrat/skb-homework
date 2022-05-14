package at2.ivanov.nikita.consumer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarDto implements Serializable {
    private String ownerName;
    private String brandName;
    private String carNumber;
}
