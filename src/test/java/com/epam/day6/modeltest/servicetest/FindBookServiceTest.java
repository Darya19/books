package com.epam.day6.modeltest.servicetest;

import com.epam.day6.controller.BookController;
import com.epam.day6.controller.response.Response;
import com.epam.day6.controller.response.ResponseHelper;
import com.epam.day6.exception.BookServiceException;
import com.epam.day6.model.entity.Book;
import com.epam.day6.model.entity.BookArchive;
import com.epam.day6.model.service.BookService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FindBookServiceTest {

    BookService service;
    BookArchive archive;

    @BeforeClass
    public void setUp() {
        service = new BookService();
        archive = BookArchive.getArchive();
    }

    @Test
    public void FindByIdPositiveTest() {
        try {
        List<Book> actual = service.findById("5");
        List<Book> foundBooks = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        authors.add("Ralph Johnson");
        foundBooks.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
        assertEquals(foundBooks, actual);}
        catch (BookServiceException e){
            fail();
        }
    }

    @Test
    public void FindByIdNotFoundPositiveTest() {
        try{
        List<Book> actual = service.findById("8");
        assertEquals(new ArrayList<>(), actual);}
        catch (BookServiceException e){
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class, expectedExceptionsMessageRegExp = "parsing issues")
    public void findByIdNegativeParsingTest() throws BookServiceException{
        service.findById("hgfj");
    }

    @Test
    public void FindByTitlePositiveTest() {
        List<Book> actual = service.findByTitle("Ralph Johnson: Complete Works");
        List<Book> foundBooks = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        authors.add("Ralph Johnson");
        foundBooks.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
        assertEquals(foundBooks, actual);
    }

    @Test
    public void FindByTitleNotFoundPositiveTest() {
        List<Book> actual = service.findByTitle("Ralph Johnson");
        assertEquals(new ArrayList<>(), actual);
    }

    @Test
    public void FindByAuthorsPositiveTest() {
        List<Book> actual = service.findByAuthor("Ralph Johnson");
        List<Book> expected = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        authors.add("Erich Gamma");
        authors.add("Richard Helm");
        authors.add("Ralph Johnson");
        authors.add("John Vlissides");
        expected.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                authors, 236.99, 312));
        authors = new ArrayList<>();
        authors.add("Ralph Johnson");
        expected.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
        assertEquals(expected, actual);
    }

    @Test
    public void FindByAuthorNotFoundPositiveTest() {
        List<Book> actual = service.findByAuthor("Ralson");
        assertEquals(new ArrayList<>(), actual);
    }

    @Test
    public void FindByPricePositiveTest() {
        try {
        List<Book> actual = service.findByPrice("236.99");
        List<Book> expected = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        authors.add("Erich Gamma");
        authors.add("Richard Helm");
        authors.add("Ralph Johnson");
        authors.add("John Vlissides");
        expected.add(new Book(4, "Design Patterns: Elements of Reusable Object-Oriented Software",
                authors, 236.99, 312));
        authors = new ArrayList<>();
        authors.add("Ralph Johnson");
        expected.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
        assertEquals(expected, actual);}
        catch (BookServiceException e){
            fail();
        }
    }

    @Test
    public void FindByPriceNotFoundPositiveTest() {
        try {
            List<Book> actual = service.findByPrice("100.0");
               assertEquals(new ArrayList<>(), actual);}
        catch (BookServiceException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class, expectedExceptionsMessageRegExp = "parsing issues")
    public void findByPriceNegativeParsingTest() throws BookServiceException{
        service.findByPrice("hgh");
    }

    @Test
    public void FindByPagesCommandPositiveTest() {
        try{
        List<Book> actual = service.findByPages("448");
        List<Book> expected = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        authors.add("Ralph Johnson");
        expected.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
        assertEquals(expected, actual);}
        catch (BookServiceException e) {
            fail();
        }
    }

    @Test
    public void FindByPagesCommandNotFoundPositiveTest() {
        try{
            List<Book> actual = service.findByPages("132");
        assertEquals(new ArrayList<>(), actual); }
        catch (BookServiceException e){
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class, expectedExceptionsMessageRegExp = "parsing issues")
    public void findByPagesCommandNegativeParsingTest() throws BookServiceException {
        service.findByPages("ghk");
    }
}
