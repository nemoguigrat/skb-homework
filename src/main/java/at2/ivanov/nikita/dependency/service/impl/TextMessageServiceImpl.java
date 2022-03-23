package at2.ivanov.nikita.dependency.service.impl;

import at2.ivanov.nikita.dependency.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Service(value = "TextService")
public class TextMessageServiceImpl implements MessageService {
    private byte[] message;

    @PostConstruct
    public void init() {
        log.warn("TextMessageService born.");
    }

    @PreDestroy
    public void destroy() {
        log.warn("TextMessageService destroy.");
    }

    @Override
    public byte[] getMessage() {
        return message;
    }

    @Override
    public void setMessage(byte[] message) {
        this.message = message;
    }
}
