package ru.avdeev.rempmm_bot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.avdeev.rempmm_bot.dto.BotMessage;
import ru.avdeev.rempmm_bot.service.RemPmmBot;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final RemPmmBot bot;

    @PostMapping("/send")
    private void sendMessage(@RequestBody BotMessage message) {
        String msg = String.format("Абонент %s просит Вас перезвонить:\nТелефон: %s\nОписание: %s",
                message.getName(),
                message.getPhone(),
                message.getIssue()
        );
        bot.sendMessage(message.getId(), msg);
    }
}
