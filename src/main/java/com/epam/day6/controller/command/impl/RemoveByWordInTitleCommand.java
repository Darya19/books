package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.Command;
import com.epam.day6.exception.BookServiceException;
import com.epam.day6.response.ErrorCode;
import com.epam.day6.response.Response;
import com.epam.day6.service.BookService;
import com.epam.day6.util.ResponseHelper;

import java.util.List;
import java.util.Map;

public class RemoveByWordInTitleCommand implements Command {

    private static final String WORD_IN_TITLE = "word in title";

    @Override
    public Response execute(Map<String, List<String>> data) {
        BookService service = new BookService();
        List<String> word = data.get(WORD_IN_TITLE);
        List foundBooks = null;
        try {
            foundBooks = service.removeByWordInTitle(word.get(0));
        } catch (BookServiceException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.BOOK_PRESENT_ERROR);
        }
        return ResponseHelper.makeOkResponse(foundBooks);
    }
}
