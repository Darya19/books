package com.epam.day6.controller.command.impl;

import com.epam.day6.controller.command.ICommand;
import com.epam.day6.response.ErrorCode;
import com.epam.day6.response.Response;
import com.epam.day6.util.ResponseHelper;

import java.util.List;
import java.util.Map;

public class EmptyICommand implements ICommand {

    @Override
    public Response execute(Map<String, List<String>> data) {
        return ResponseHelper.makeErrorResponse(ErrorCode.EMPTY_COMMAND);
    }
}
