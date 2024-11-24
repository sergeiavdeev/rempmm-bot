package ru.avdeev.rempmm_bot.dto;

import lombok.Data;

@Data
public class BotMessage {

    private long id;
    private String phone;
    private String name;
    private String issue;
}
