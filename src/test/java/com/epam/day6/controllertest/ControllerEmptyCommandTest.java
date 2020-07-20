package com.epam.day6.controllertest;

import com.epam.day6.controller.BookController;
import com.epam.day6.controller.response.Response;
import com.epam.day6.controller.response.ResponseHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ControllerEmptyCommandTest {

    BookController controller;

    @BeforeClass
    public void setUp() {
        controller = BookController.getInstance();
    }

    @Test
    public void SortEmptyCommandTest() {
        Map<String, String> requestData = new HashMap<>();
        Response actual = controller.doGet("", requestData);
        Response expected = ResponseHelper.makeErrorResponse("Command don't set");
        assertEquals(expected, actual);
    }

    @Test
    public void SortEmptyCommandNullRequestTest() {
        Map<String, String> requestData = new HashMap<>();
        Response actual = controller.doGet(null, requestData);
        Response expected = ResponseHelper.makeErrorResponse("Command don't set");
        assertEquals(expected, actual);
    }
}
