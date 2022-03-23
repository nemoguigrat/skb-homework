package at2.ivanov.nikita.dependency.service;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class UselessService {
    @PostConstruct
    public void init() {
        log.warn("Useless service born.");
    }

    @PreDestroy
    public void destroy() {
        log.warn("Useless service destroy.");
    }
}
