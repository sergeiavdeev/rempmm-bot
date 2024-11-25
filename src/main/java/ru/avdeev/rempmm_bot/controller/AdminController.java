package ru.avdeev.rempmm_bot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import ru.avdeev.rempmm_bot.config.BotProperties;
import ru.avdeev.rempmm_bot.config.RempmmBot;
import ru.avdeev.rempmm_bot.dto.BotMessage;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
@Configuration
public class AdminController {

    private final RempmmBot bot;
    private final BotProperties botProperties;


    @PutMapping("/send")
    private void sendMessage(@RequestBody BotMessage message) {

        String msg = String.format("Абонент %s просит Вас перезвонить.\nТелефон: %s\nОписание: %s",
                message.getName(),
                message.getPhone(),
                message.getIssue());

        botProperties.getReceivers().forEach(el -> bot.sendMessage(el, msg));
    }
}
