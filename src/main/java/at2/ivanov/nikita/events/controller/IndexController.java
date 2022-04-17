package at2.ivanov.nikita.events.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Controller
public class IndexController {
    @GetMapping
    public String index(@RequestHeader Map<String, String> headers, Model model) {
        model.addAttribute("headers", headers);
        return "index";
    }
}
