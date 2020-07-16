package com.epam.day6.controller;

import com.epam.day6.controller.command.ActionProvider;
import com.epam.day6.controller.command.Command;
import com.epam.day6.response.Response;

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

    public void doGet(String request, Map<String, List<String>> data) {
        Command command = ActionProvider.defineCommand(request);
        Response response = command.execute(data);
    }
}
