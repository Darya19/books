package com.epam.day6.modeltest.servicetest;

import com.epam.day6.model.entity.Book;
import com.epam.day6.model.entity.BookArchive;
import com.epam.day6.model.service.BookService;
import com.epam.day6.controllertest.StaticDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class SortBooksServiceTest {

    BookService service;
    BookArchive archive;

    @BeforeClass
    public void setUp() {
        service = new BookService();
        archive = BookArchive.getArchive();
    }

    @Test(dataProvider = "sorted archive", dataProviderClass = StaticDataProvider.class)
    public void SortByIdPositiveTest(List<Book> expected) {
        List<Book> actual = service.sortById();
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive", dataProviderClass = StaticDataProvider.class)
    public void SortByPagesPositiveTest(List<Book> expected) {
        List<Book> actual = service.sortByPages();
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive-2", dataProviderClass = StaticDataProvider.class)
    public void SortByTitlePositiveTest(List<Book> expected) {
        List<Book> actual = service.sortByTitle();
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive-3", dataProviderClass = StaticDataProvider.class)
    public void SortByAuthorPositiveTest(List<Book> expected) {
        List<Book> actual = service.sortByAuthor();
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive-4", dataProviderClass = StaticDataProvider.class)
    public void SortByPricePositiveTest(List<Book> expected) {
        List<Book> actual = service.sortByPrice();
        assertEquals(expected, actual);
    }
}
