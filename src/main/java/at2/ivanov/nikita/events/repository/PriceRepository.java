package at2.ivanov.nikita.events.repository;

import at2.ivanov.nikita.events.dto.PriceDto;
import at2.ivanov.nikita.events.service.PriceService;
import org.springframework.stereotype.Repository;

@Repository
public class PriceRepository {
    private Integer currentId;

    public PriceRepository() {
        this.currentId = 0;
    }

    public PriceDto save(PriceDto dto) {
        dto.getInfo().put("id", currentId);
        currentId++;
        return dto;
    }
}
