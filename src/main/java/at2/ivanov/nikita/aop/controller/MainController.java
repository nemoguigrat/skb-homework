package at2.ivanov.nikita.aop.controller;

import at2.ivanov.nikita.aop.aspect.RequestCount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    // добавил 2 эндпоинта, счетчики для каждого незавимимые
    @RequestCount
    @GetMapping("/aspect/first")
    public String aspectFirst() {
        return "Access";
    }

    @RequestCount
    @GetMapping("/aspect/second")
    public String aspectSecond() {
        return "Accesssss";
    }
}
