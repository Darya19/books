package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.Command;
import com.epam.day6.controller.response.Response;
import com.epam.day6.controller.response.ResponseHelper;
import com.epam.day6.model.entity.Book;
import com.epam.day6.model.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SortCommand implements Command {

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String AUTHOR = "author";
    private static final String PRICE = "price";
    private static final String PAGES = "pages";
    List<Book> foundBooks;

    @Override
    public Response execute(Map<String, String> data) {
        if (data == null || data.isEmpty()) {
            return ResponseHelper.makeErrorResponse("impossible define what find");
        }
        BookService service = new BookService();
        List<String> command = new ArrayList<>();
        for (String key : data.keySet()) {
            command.add(key);
        }
        switch (command.get(0)) {
            case ID:
                foundBooks = service.sortById();
                break;
            case TITLE:
                foundBooks = service.sortByTitle();
                break;
            case AUTHOR:
                foundBooks = service.sortByAuthor();
                break;
            case PRICE:
                foundBooks = service.sortByPrice();
                break;
            case PAGES:
                foundBooks = service.sortByPages();
                break;
        }
        return ResponseHelper.makeOkResponse(foundBooks);
    }
}
