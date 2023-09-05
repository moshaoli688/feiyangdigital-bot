package top.feiyangdigital.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TgWebhookBot extends TelegramWebhookBot {

    private String botName;

    private String botToken;

    private String botPath;

    @Autowired
    private TgLongPollingBot tgLongPollingBot;

    @Autowired
    private GroupCommands groupCommands;

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        tgLongPollingBot.onUpdateReceived(update);
        return null;
    }

    public void setGroupCommands() throws TelegramApiException {
        groupCommands.setGroupCommands(this);
    }


    @Override
    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    @Override
    public String getBotPath() {
        return null;
    }

    public void setBotPath(String botPath) {
        this.botPath = botPath;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }
}