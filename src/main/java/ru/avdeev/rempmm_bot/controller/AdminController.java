package ru.avdeev.rempmm_bot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.avdeev.rempmm_bot.config.RempmmBot;
import ru.avdeev.rempmm_bot.dto.BotMessage;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final RempmmBot bot;

    @PutMapping("/send")
    private void sendMessage(@RequestBody BotMessage message) {

        String msg = String.format("Абонент %s просит Вас перезвонить.\nТелефон: %s\nОписание: %s",
                message.getName(),
                message.getPhone(),
                message.getIssue());
        bot.SendMessage(267239507L, msg);
    }
}
