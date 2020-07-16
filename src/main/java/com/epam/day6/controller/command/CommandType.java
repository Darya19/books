package com.epam.day6.controller.command;

import com.epam.day6.controller.command.impl.*;

public enum CommandType {
    ADD_BOOK {{
        this.command = new AddBookCommand();
    }},
    REMOVE_BOOK {{
        this.command = new RemoveBookCommand();
    }},
    FIND_BY_ID {{
        this.command = new FindByIdCommand();
    }},
    FIND_BY_AUTHORS {{
        this.command = new FindByAuthorsCommand();
    }},
    FIND_BY_PAGES {{
        this.command = new FindByPagesCommand();
    }},
    FIND_BY_PRICE {{
        this.command = new FindByPriceCommand();
    }},
    FIND_BY_TITLE {{
        this.command = new FindByTitleCommand();
    }},
    FIND_BY_WORD_IN_TITLE {{
        this.command = new FindByWordInTitleCommand();
    }},
    REMOVE_BY_WORD_IN_TITLE {{
        this.command = new RemoveByWordInTitleCommand();
    }},
    SORT_BY_AUTHORS {{
        this.command = new SortByAuthorsCommand();
    }},
    SORT_BY_ID {{
        this.command = new SortByIdCommand();
    }},
    SORT_BY_PAGES {{
        this.command = new SortByPagesCommand();
    }},
    SORT_BY_PRICE {{
        this.command = new SortByPriceCommand();
    }},
    SORT_BY_TITLE {{
        this.command = new SortByTitleCommand();
    }};

    Command command;

    public Command getCommand() {
        return command;
    }
}
