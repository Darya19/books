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

public class RemoveBookServiceTest {
    BookService service;
    BookArchive archive;

    @BeforeClass
    public void setUp() {
        service = new BookService();
        archive = BookArchive.getArchive();
    }

    @Test(dataProvider = "updated archive-2", dataProviderClass = StaticDataProvider.class)
    public void removeBookPositiveTest(List<Book> archive) {
        List<String> author = new ArrayList<>();
        author.add("Alan Alexander Milne");
        author.add("P.G.Wodehouse");
        try {
            List<Book> actual = service.removeBook("Winnie-the-Pooh",
                    author, "458.96", "194");
            assertEquals(archive, actual);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativeAuthorValidationTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        service.removeBook("Winnie-the-Pooh",
                author, "458.96", "194");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativeTitleValidationTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("Alan Alexander Milne");
        author.add("P.G.Wodehouse");
        service.removeBook("Wi",
                author, "458.96", "194");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativePriceValidationTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("Alan Alexander Milne");
        author.add("P.G.Wodehouse");
        service.removeBook("Winnie-the-Pooh",
                author, "-966", "194");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "invalid input data")
    public void addBookNegativePagesValidationTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("Alan Alexander Milne");
        author.add("P.G.Wodehouse");
        service.removeBook("Winnie-the-Pooh",
                author, "458.96", "5000");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "parsing issues")
    public void addBookNegativePagesParsingTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("Alan Alexander Milne");
        author.add("P.G.Wodehouse");
        service.removeBook("Winnie-the-Pooh",
                author, "458.96", "lkjljo");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "parsing issues")
    public void addBookNegativePriceParsingTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("Alan Alexander Milne");
        author.add("P.G.Wodehouse");
        service.removeBook("Winnie-the-Pooh",
                author, "xfbd", "194");
    }

    @Test(priority = 1, expectedExceptions = BookServiceException.class,
            expectedExceptionsMessageRegExp = "book doesn't exist")
    public void addBookNegativePresentTest() throws BookServiceException {
        List<String> author = new ArrayList<>();
        author.add("J.K. Rowling");
        service.removeBook("Harry Potter",
                author, "780.8", "219");
    }
}
