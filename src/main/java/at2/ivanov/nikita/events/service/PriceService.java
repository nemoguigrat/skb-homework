package at2.ivanov.nikita.events.service;

import at2.ivanov.nikita.events.dto.PriceDto;
import at2.ivanov.nikita.events.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceService {
    private final PriceRepository priceRepository;

    public PriceDto save(PriceDto price) {
        return priceRepository.save(price);
    }
}
