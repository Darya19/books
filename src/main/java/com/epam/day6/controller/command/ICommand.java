package com.epam.day6.controller.command;

import com.epam.day6.response.Response;

import java.util.List;
import java.util.Map;

public interface ICommand {

    Response execute(Map<String, List<String>> data);
}
