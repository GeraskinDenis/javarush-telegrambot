package geraskindenis.javarushtelegrambot.command;

import com.google.common.collect.ImmutableMap;
import geraskindenis.javarushtelegrambot.service.SendBotMessageService;

import static geraskindenis.javarushtelegrambot.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIndentifier) {
        return commandMap.getOrDefault(commandIndentifier, unknownCommand);
    }
}
