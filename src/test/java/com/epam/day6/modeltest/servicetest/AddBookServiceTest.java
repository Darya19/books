package com.epam.day6.modeltest.servicetest;

import com.epam.day6.controllertest.StaticDataProvider;
import com.epam.day6.exception.BookServiceException;
import com.epam.day6.model.entity.Book;
import com.epam.day6.model.entity.BookArchive;
import com.epam.day6.model.service.BookService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AddBookServiceTest {

    BookService service;
    BookArchive archive;

    @BeforeClass
    public void setUp() {
        service = new BookService();
        archive = BookArchive.getArchive();
    }

    @Test(dataProvider = "updated archive", dataProviderClass = StaticDataProvider.class)
    public void addBookPositiveTest(List<Book> archive) {
        List<String> author = new ArrayList<>();
        author.add("J.K. Rowling");
        try {
            List<Book> actual = service.addBook("Harry Potter and the chamber of secrets",
                    author, "942.38", "615");
            assertEquals(archive, actual);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativeAuthorValidationTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        service.addBook("Harry Potter and the chamber of secrets",
                author, "942.38", "615");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativeTitleValidationTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("J.K. Rowling");
        service.addBook("Ha", author, "942.38", "615");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativePriceValidationTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("J.K. Rowling");
        service.addBook("Harry Potter and the chamber of secrets",
                author, "-85", "615");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativePagesValidationTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("J.K. Rowling");
        service.addBook("Harry Potter and the chamber of secrets",
                author, "942.58", "0");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "parsing issues")
    public void addBookNegativePagesParsingTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("J.K. Rowling");
        service.addBook("Harry Potter and the chamber of secrets",
                author, "942.58", "jhhhvj");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "parsing issues")
    public void addBookNegativePriceParsingTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("J.K. Rowling");
        service.addBook("Harry Potter and the chamber of secrets",
                author, "bghj", "458");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "book already exist")
    public void addBookNegativePresentTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("J.K. Rowling");
        service.addBook("Harry Potter and the Philosopher’s Stone",
                author, "780.8", "219");
    }
}
