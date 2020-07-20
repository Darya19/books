package com.epam.day6.controller.command;

import com.epam.day6.controller.response.Response;

import java.util.List;
import java.util.Map;

public interface Command {

    Response execute(Map<String, String> data);
}
