package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.ICommand;
import com.epam.day6.response.ErrorCode;
import com.epam.day6.response.Response;
import com.epam.day6.service.BookService;
import com.epam.day6.util.ResponseHelper;

import java.util.List;
import java.util.Map;

public class FindById implements ICommand {

    private static final String ID = "id";

    @Override
    public Response execute(Map<String, List<String>> data) {
        BookService service = new BookService();
        List<String> id = data.get(ID);
        try {
            int intId = Integer.parseInt(id.get(0));
            Response response = service.findById(intId);
            return response;
        } catch (NumberFormatException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
        }
    }
}