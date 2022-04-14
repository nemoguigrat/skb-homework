package at2.ivanov.nikita.events.controller;

import at2.ivanov.nikita.events.dto.PriceDto;
import at2.ivanov.nikita.events.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PriceController {
    private final PriceService priceService;

    @PostMapping("/price")
    public PriceDto savePrice(@RequestBody PriceDto price) {
        return priceService.save(price);
    }
}
