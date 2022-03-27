package at2.ivanov.nikita.homework.service;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

@Slf4j
public class DefaultClass {
    @PostConstruct
    public void init() {
        log.warn(this.getClass().getName() + " born!");
    }
}
