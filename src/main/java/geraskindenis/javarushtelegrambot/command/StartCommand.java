package geraskindenis.javarushtelegrambot.command;

import geraskindenis.javarushtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE = "Hello! I'm JavaRush Telegram Bot!";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
