package at2.ivanov.nikita.dependency.service.impl;

import at2.ivanov.nikita.dependency.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Service(value = "ImageService")
public class ImageMessageServiceImpl implements MessageService {
    private byte[] message;

    @PostConstruct
    public void init() {
        log.warn("ImageMessageService born.");
    }

    @PreDestroy
    public void destroy() {
        log.warn("ImageMessageService destroy.");
    }

    public byte[] getMessage() {
        return message;
    }

    @Override
    public void setMessage(byte[] message) {
        this.message = message;
    }
}
