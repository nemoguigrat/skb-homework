package at2.ivanov.nikita.producer.dto;

import lombok.Data;

@Data
public class CarResponse {
    private Long id;
    private String ownerName;
    private String brandName;
    private String carNumber;
}
