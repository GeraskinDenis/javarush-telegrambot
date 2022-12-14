package geraskindenis.javarushtelegrambot.command;

import geraskindenis.javarushtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static geraskindenis.javarushtelegrambot.command.CommandName.*;

public class HelpCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    public static final String HELP_MESSAGE = String.format("\uD83C\uDF1F<b>Доступные команды:</b>\n\n"
                    + "✅%s - начать работу со мной\n\n"
                    + "✅%s - приостоновить работу со мной\n\n"
                    + "❓%s - получить помощь в работе со мной\n",
            START.getCommandName(),
            STOP.getCommandName(),
            HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
