package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.Command;
import com.epam.day6.response.Response;
import com.epam.day6.service.BookService;
import com.epam.day6.util.ResponseHelper;

import java.util.List;
import java.util.Map;

public class FindByWordInTitleCommand implements Command {
    private static final String WORD_IN_TITLE = "word in title";

    @Override
    public Response execute(Map<String, List<String>> data) {
        BookService service = new BookService();
        List<String> word = data.get(WORD_IN_TITLE);
        List foundBooks = service.findByWordInTitle(word.get(0));
        return ResponseHelper.makeOkResponse(foundBooks);
    }
}
