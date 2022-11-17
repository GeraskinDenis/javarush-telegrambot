package geraskindenis.javarushtelegrambot.command;

import geraskindenis.javarushtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command {
    public static final String UNKNOWN_MESSAGE = "Я не понимаю вас \uD83E\uDD37, напишите '/help' что бы узнать мои команды.";
    private final SendBotMessageService sendBotMessageService;

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
