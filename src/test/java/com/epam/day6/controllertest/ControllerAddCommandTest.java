package com.epam.day6.controllertest;

import com.epam.day6.controller.BookController;
import com.epam.day6.controller.response.Response;
import com.epam.day6.controller.response.ResponseHelper;
import com.epam.day6.model.entity.Book;
import com.epam.day6.model.entity.BookArchive;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ControllerAddCommandTest {

    BookController controller;
    BookArchive archive;

    @BeforeClass
    public void setUp() {
        controller = BookController.getInstance();
        archive = BookArchive.getArchive();
    }

    @Test(dataProvider = "updated archive", dataProviderClass = StaticDataProvider.class)
    public void addCommandPositiveTest(List<Book> archive) {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("title", "Harry Potter and the chamber of secrets");
        requestData.put("authors", "J.K. Rowling");
        requestData.put("price", "942.38");
        requestData.put("pages", "615");
        Response actual = controller.doGet("add", requestData);
        Response expected = ResponseHelper.makeOkResponse(archive);
        assertEquals(expected, actual);
    }

    @Test(priority = 1, dataProvider = "invalid book", dataProviderClass = StaticDataProvider.class)
    public void addCommandNegativeValidationTest(Map<String, String> data) {
        Response actual = controller.doGet("add", data);
        Response expected = ResponseHelper.makeErrorResponse("invalid input data");
        assertEquals(expected, actual);
    }

    @Test(priority = 1, dataProvider = "incorrect book", dataProviderClass = StaticDataProvider.class)
    public void addCommandNegativeParsingTest(Map<String, String> data) {
        Response actual = controller.doGet("add", data);
        Response expected = ResponseHelper.makeErrorResponse("parsing issues");
        assertEquals(expected, actual);
    }

    @Test(priority = 2)
    public void addCommandNegativePresentTest() {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("title", "Harry Potter and the Philosopher’s Stone");
        requestData.put("authors", "J.K. Rowling");
        requestData.put("price", "780.8");
        requestData.put("pages", "219");
        Response actual = controller.doGet("add", requestData);
        Response expected = ResponseHelper.makeErrorResponse("book already exist");
        assertEquals(expected, actual);
    }
}
