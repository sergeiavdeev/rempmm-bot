package ru.avdeev.rempmm_bot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "bot")
@Data
public class BotProperties {

    //@Value("${bot.token}")
    private String token;

    //@Value("${botLocal.receivers}")
    private List<Long> receivers;
}
