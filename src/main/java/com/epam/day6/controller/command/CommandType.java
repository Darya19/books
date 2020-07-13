package com.epam.day6.controller.command;

import com.epam.day6.controller.command.impl.AddBook;
import com.epam.day6.controller.command.impl.FindById;
import com.epam.day6.controller.command.impl.RemoveBook;

public enum CommandType {
    ADD_BOOK {{
        this.command = new AddBook();
    }},
    REMOVE_BOOK {{
        this.command = new RemoveBook();
    }},
    FIND_BY_ID {{
        this.command = new FindById();
    }};

    ICommand command;

    public ICommand getCommand() {
        return command;
    }
}
