package at2.ivanov.nikita.producer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarRequest implements Serializable {
    private String ownerName;
    private String brandName;
    private String carNumber;
}
