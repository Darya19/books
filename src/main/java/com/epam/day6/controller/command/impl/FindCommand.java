package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.Command;
import com.epam.day6.controller.response.Response;
import com.epam.day6.controller.response.ResponseHelper;
import com.epam.day6.exception.BookServiceException;
import com.epam.day6.model.entity.Book;
import com.epam.day6.model.service.BookService;

import java.util.List;
import java.util.Map;

public class FindCommand implements Command {

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String AUTHOR = "author";
    private static final String PRICE = "price";
    private static final String PAGES = "pages";
    private static final String WORD_IN_TITLE = "word";
    List<Book> foundBooks;

    @Override
    public Response execute(Map<String, String> data) {
        BookService service = new BookService();
        for (String key : data.keySet()) {
            try {
                switch (key) {
                    case ID:
                        foundBooks = service.findById(data.get(key));
                        break;
                    case TITLE:
                        foundBooks = service.findByTitle(data.get(key));
                        break;
                    case AUTHOR:
                        foundBooks = service.findByAuthor(data.get(key));
                        break;
                    case PRICE:
                        foundBooks = service.findByPrice(data.get(key));
                        break;
                    case PAGES:
                        foundBooks = service.findByPages(data.get(key));
                        break;
                }
                return ResponseHelper.makeOkResponse(foundBooks);
            } catch (BookServiceException e) {
                return ResponseHelper.makeErrorResponse(e.getMessage());
            }
        }
        return ResponseHelper.makeErrorResponse("impossible define what find");
    }
}

