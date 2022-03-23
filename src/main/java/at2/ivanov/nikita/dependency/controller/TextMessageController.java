package at2.ivanov.nikita.dependency.controller;

import at2.ivanov.nikita.dependency.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextMessageController {
    @Qualifier("TextService")
    @Autowired
    private MessageService textMessageService;

    @GetMapping("/text")
    public byte[] getText() {
        return textMessageService.getMessage();
    }

    @PostMapping("/text")
    public void setMessage(@RequestParam String string) {
        textMessageService.setMessage(string.getBytes());
    }
}
