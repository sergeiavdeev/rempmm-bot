package ru.avdeev.rempmm_bot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.avdeev.rempmm_bot.dto.BotMessage;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    //private final RemPmmBot bot;

    @PostMapping("/send")
    private void sendMessage(@RequestBody BotMessage message) {

    }
}
