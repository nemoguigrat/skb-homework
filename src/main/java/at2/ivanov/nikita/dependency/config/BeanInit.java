package at2.ivanov.nikita.dependency.config;

import at2.ivanov.nikita.dependency.service.UselessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInit {
    @Bean
    public UselessService createUselessService(){
        return new UselessService();
    }
}
