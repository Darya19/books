package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.Command;
import com.epam.day6.response.ErrorCode;
import com.epam.day6.response.Response;
import com.epam.day6.service.BookService;
import com.epam.day6.util.ResponseHelper;

import java.util.List;
import java.util.Map;

public class FindByPriceCommand implements Command {

    private static final String PRICE = "price";

    @Override
    public Response execute(Map<String, List<String>> data) {
        BookService service = new BookService();
        List<String> price = data.get(PRICE);
        try {
            double doublePrice = Double.parseDouble(price.get(0));
            List foundBooks = service.findByPrice(doublePrice);
            return ResponseHelper.makeOkResponse(foundBooks);
        } catch (NumberFormatException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
        }
    }
}
