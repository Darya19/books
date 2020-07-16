package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.Command;
import com.epam.day6.model.entity.Book;
import com.epam.day6.response.Response;
import com.epam.day6.service.BookService;
import com.epam.day6.util.ResponseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindByAuthorsCommand implements Command {

    private static final String AUTHOR = "author";

    @Override
    public Response execute(Map<String, List<String>> data) {
        List<Book> foundBooks = new ArrayList<>();
        BookService service = new BookService();
        for (String author : data.get(AUTHOR)) {
            List<Book> tmp = service.findByAuthor(author);
            foundBooks.addAll(tmp);
        }
        return ResponseHelper.makeOkResponse(foundBooks);
    }
}
