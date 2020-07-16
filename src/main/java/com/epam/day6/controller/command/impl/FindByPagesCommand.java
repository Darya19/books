package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.Command;
import com.epam.day6.response.ErrorCode;
import com.epam.day6.response.Response;
import com.epam.day6.service.BookService;
import com.epam.day6.util.ResponseHelper;

import java.util.List;
import java.util.Map;

public class FindByPagesCommand implements Command {

    private static final String PAGES = "pages";

    @Override
    public Response execute(Map<String, List<String>> data) {
        BookService service = new BookService();
        List<String> pages = data.get(PAGES);
        try {
            int intPages = Integer.parseInt(pages.get(0));
            List foundBooks = service.findByPages(intPages);
            return ResponseHelper.makeOkResponse(foundBooks);
        } catch (NumberFormatException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
        }
    }
}
