package at2.ivanov.nikita.events.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Data
@JsonPropertyOrder(value = {"price", "info"})
public class PriceDto {
    @JsonProperty("price")
    private Float price;
    private Map<String, Object> info;

    @JsonProperty("info") // я в курсе, что можно просто сделать еще один объект, но я хотел попробовать, я так еще не делал
    public void unpackInfo(Map<String, Object> info) {
        info.put("date", LocalDate.parse((String) info.get("date")));
        this.info = info;
    }
}
