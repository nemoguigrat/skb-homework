package at2.ivanov.nikita.dependency.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Slf4j
@Service(value = "ImageService")
public class ImageMessageService implements MessageService {
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
