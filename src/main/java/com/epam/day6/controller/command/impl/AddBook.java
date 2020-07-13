package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.ICommand;
import com.epam.day6.model.entity.Book;
import com.epam.day6.response.ErrorCode;
import com.epam.day6.response.Response;
import com.epam.day6.response.Status;
import com.epam.day6.service.BookService;
import com.epam.day6.util.ResponseHelper;

import java.util.List;
import java.util.Map;

public class AddBook implements ICommand {
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String AUTHORS = "authors";
    private static final String PRICE = "price";
    private static final String PAGES = "pages";

    @Override
    public Response execute(Map<String, List<String>> data) {
        BookService service = new BookService();
        List<String> id = data.get(ID);
        List<String> title = data.get(TITLE);
        List<String> authors = data.get(AUTHORS);
        List<String> price = data.get(PRICE);
        List<String> pages = data.get(PAGES);
        try {
            int intId = Integer.parseInt(id.get(0));
            double doublePrice = Double.parseDouble(price.get(0));
            int intPages = Integer.parseInt(pages.get(0));
            Book book = new Book(intId, title.get(0), authors, doublePrice, intPages);
            Response response = service.addBook(book);
            return response;
        } catch (NumberFormatException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
        }
    }
}

