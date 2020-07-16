package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.Command;
import com.epam.day6.exception.BookServiceException;
import com.epam.day6.model.entity.Book;
import com.epam.day6.response.ErrorCode;
import com.epam.day6.response.Response;
import com.epam.day6.service.BookService;
import com.epam.day6.util.ResponseHelper;

import java.util.List;
import java.util.Map;

public class AddBookCommand implements Command {
    private static final String TITLE = "title";
    private static final String AUTHORS = "authors";
    private static final String PRICE = "price";
    private static final String PAGES = "pages";

    @Override
    public Response execute(Map<String, List<String>> data) {
        BookService service = new BookService();
        List<String> title = data.get(TITLE);
        List<String> authors = data.get(AUTHORS);
        List<String> price = data.get(PRICE);
        List<String> pages = data.get(PAGES);
        try {
            double doublePrice = Double.parseDouble(price.get(0));
            int intPages = Integer.parseInt(pages.get(0));
            Book book = new Book(title.get(0), authors, doublePrice, intPages);
            return ResponseHelper.makeOkResponse(service.addBook(book));
        } catch (NumberFormatException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
        } catch (BookServiceException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
        }
    }
}

