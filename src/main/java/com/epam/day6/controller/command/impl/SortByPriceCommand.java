package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.Command;
import com.epam.day6.model.entity.Book;
import com.epam.day6.response.Response;
import com.epam.day6.service.BookService;
import com.epam.day6.util.ResponseHelper;

import java.util.List;
import java.util.Map;

public class SortByPriceCommand implements Command {

    @Override
    public Response execute(Map<String, List<String>> data) {
        BookService service = new BookService();
        List<Book> foundBooks = service.sortByPrice();
        return ResponseHelper.makeOkResponse(foundBooks);
    }
}
