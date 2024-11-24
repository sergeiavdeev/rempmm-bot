package ru.avdeev.rempmm_bot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.avdeev.rempmm_bot.config.BotConfig;

@Component
public class RemPmmBot extends TelegramLongPollingBot {

    private final BotConfig config;

    public RemPmmBot(BotConfig config) {
        super(config.getToken());
        this.config = config;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            String message = update.getMessage().getText();
            long id = update.getMessage().getChatId();

            switch (message) {
                case "/start":
                    sendMessage(id, "Hello, !" + id);
                    break;
                case "/name":
                    sendMessage(id, update.getMessage().getChat().getFirstName());
                    break;
                case "/id":
                    sendMessage(id, "" + update.getMessage().getChat().getId());
                    break;
                default:
                    sendMessage(id, "Id: " + id);

            }
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    public void sendMessage(Long chatId, String textToSend){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
