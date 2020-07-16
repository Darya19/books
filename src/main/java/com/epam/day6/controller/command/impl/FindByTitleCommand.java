package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.Command;
import com.epam.day6.response.Response;
import com.epam.day6.service.BookService;
import com.epam.day6.util.ResponseHelper;

import java.util.List;
import java.util.Map;

public class FindByTitleCommand implements Command {

    private static final String TITLE = "title";

    @Override
    public Response execute(Map<String, List<String>> data) {
        BookService service = new BookService();
        List<String> title = data.get(TITLE);
        List foundBooks = service.findByTitle(title.get(0));
        return ResponseHelper.makeOkResponse(foundBooks);
    }
}
