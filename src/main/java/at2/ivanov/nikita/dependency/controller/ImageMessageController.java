package at2.ivanov.nikita.dependency.controller;

import at2.ivanov.nikita.dependency.service.MessageService;
import at2.ivanov.nikita.dependency.service.UselessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageMessageController {
    private final MessageService messageService;
    private UselessService uselessService;

    public ImageMessageController(@Qualifier("ImageService") MessageService messageService) {
        this.messageService = messageService;
    }

    @Autowired
    public void setUselessService(UselessService uselessService){
        this.uselessService = uselessService;
    }

    @GetMapping(path = "/image", produces = "image/bmp")
    public byte[] getImage() {
        return messageService.getMessage();
    }

    @PostMapping("/image")
    public void setImageMessage(@RequestBody byte[] bmpImage) {
        messageService.setMessage(bmpImage);
    }

}
