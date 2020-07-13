package com.epam.day6.controller;

import com.epam.day6.controller.command.ActionProvider;
import com.epam.day6.controller.command.ICommand;
import com.epam.day6.response.Response;

import java.util.List;
import java.util.Map;

public class BookController {

    public void doGet(String request, Map<String, List<String>> data){
        ICommand command = ActionProvider.defineCommand(request);
        Response response = command.execute(data);
    }
}
