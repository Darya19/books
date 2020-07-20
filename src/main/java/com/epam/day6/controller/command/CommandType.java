package com.epam.day6.controller.command;

import com.epam.day6.controller.command.impl.*;

public enum CommandType {
    ADD {{
        this.command = new AddCommand();
    }},
    REMOVE {{
        this.command = new RemoveCommand();
    }},
    FIND {{
        this.command = new FindCommand();
    }},
    SORT {{
        this.command = new SortCommand();
    }};

    Command command;

    public Command getCommand() {
        return command;
    }
}
