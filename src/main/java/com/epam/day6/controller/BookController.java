package com.epam.day6.controller;

import com.epam.day6.controller.command.ActionProvider;
import com.epam.day6.controller.command.Command;
import com.epam.day6.controller.response.Response;

import java.util.List;
import java.util.Map;

public class BookController {

    private static BookController instance;

    private BookController() {
    }

    public static BookController getInstance() {
        if (instance == null) {
            instance = new BookController();
        }
        return instance;
    }

    public Response doGet(String request, Map<String, String> data) {
        Command command = ActionProvider.defineCommand(request);
        Response response = command.execute(data);
        return response;
    }
}
