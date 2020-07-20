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

public class ControllerSortCommandTest {

    BookController controller;
    BookArchive archive;

    @BeforeClass
    public void setUp() {
        controller = BookController.getInstance();
        archive = BookArchive.getArchive();
    }

    @Test(dataProvider = "sorted archive", dataProviderClass = StaticDataProvider.class)
    public void SortByIdCommandPositiveTest(List<Book> sortedList) {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("id", "");
        Response actual = controller.doGet("sort", requestData);
        Response expected = ResponseHelper.makeOkResponse(sortedList);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive", dataProviderClass = StaticDataProvider.class)
    public void SortByPagesCommandPositiveTest(List<Book> sortedList) {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("pages", "");
        Response actual = controller.doGet("sort", requestData);
        Response expected = ResponseHelper.makeOkResponse(sortedList);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive-2", dataProviderClass = StaticDataProvider.class)
    public void SortByTitleCommandPositiveTest(List<Book> sortedList) {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("title", "");
        Response actual = controller.doGet("sort", requestData);
        Response expected = ResponseHelper.makeOkResponse(sortedList);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive-3", dataProviderClass = StaticDataProvider.class)
    public void SortByAuthorCommandPositiveTest(List<Book> sortedList) {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("author", "");
        Response actual = controller.doGet("sort", requestData);
        Response expected = ResponseHelper.makeOkResponse(sortedList);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive-4", dataProviderClass = StaticDataProvider.class)
    public void SortByPriceCommandPositiveTest(List<Book> sortedList) {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("price", "");
        Response actual = controller.doGet("sort", requestData);
        Response expected = ResponseHelper.makeOkResponse(sortedList);
        assertEquals(expected, actual);
    }

    @Test
    public void SortEmptyCommandPositiveTest() {
        Map<String, String> requestData = new HashMap<>();
        Response actual = controller.doGet("sort", requestData);
        Response expected = ResponseHelper.makeErrorResponse("impossible define how to sort");
        assertEquals(expected, actual);
    }
}
