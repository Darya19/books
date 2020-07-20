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

public class ControllerRemoveCommandTest {
    BookController controller;
    BookArchive archive;

    @BeforeClass
    public void setUp() {
        controller = BookController.getInstance();
        archive = BookArchive.getArchive();
    }

    @Test(dataProvider = "updated archive-2", dataProviderClass = StaticDataProvider.class)
    public void removeCommandPositiveTest(List<Book> bookArchive) {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("title", "Winnie-the-Pooh");
        requestData.put("authors", "Alan Alexander Milne, P.G.Wodehouse");
        requestData.put("price", "458.96");
        requestData.put("pages", "194");
        Response actual = controller.doGet("remove", requestData);
        Response expected = ResponseHelper.makeOkResponse(bookArchive);
        assertEquals(expected, actual);
    }

    @Test(priority = 1, dataProvider = "invalid book", dataProviderClass = StaticDataProvider.class)
    public void removeCommandNegativeValidationTest(Map<String, String> data) {
        Response actual = controller.doGet("remove", data);
        Response expected = ResponseHelper.makeErrorResponse("invalid input data");
        assertEquals(expected, actual);
    }

    @Test(priority = 1, dataProvider = "incorrect book", dataProviderClass = StaticDataProvider.class)
    public void removeCommandNegativeParsingTest(Map<String, String> data) {
        Response actual = controller.doGet("remove", data);
        Response expected = ResponseHelper.makeErrorResponse("parsing issues");
        assertEquals(expected, actual);
    }

    @Test(priority = 2)
    public void removeCommandNegativePresentTest() {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("title", "Stone");
        requestData.put("authors", "J.K. Rowling");
        requestData.put("price", "780.8");
        requestData.put("pages", "615");
        Response actual = controller.doGet("remove", requestData);
        Response expected = ResponseHelper.makeErrorResponse("book doesn't exist");
        assertEquals(expected, actual);
    }
}
