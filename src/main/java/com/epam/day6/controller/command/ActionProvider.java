package com.epam.day6.controller.command;

import com.epam.day6.controller.command.impl.EmptyICommand;

public class ActionProvider {

    public static ICommand defineCommand(String request) {
        ICommand command;
        if (request == null || request.isEmpty()) {
            return new EmptyICommand();
        } else {
            CommandType commandType = CommandType.valueOf(request.toUpperCase());
            command = commandType.getCommand();
        }
        return command;
    }
}
