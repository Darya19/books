package com.epam.day6.modeltest.daotest;

import com.epam.day6.controllertest.StaticDataProvider;
import com.epam.day6.exception.BookDaoException;
import com.epam.day6.model.dao.impl.BookListDaoImpl;
import com.epam.day6.model.entity.Book;
import com.epam.day6.model.entity.BookArchive;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.testng.Assert.assertTrue;

public class BookListDaoTest {

    BookListDaoImpl dao;
    BookArchive archive;

    @BeforeClass
    public void setUp() {
        dao = new BookListDaoImpl();
        archive = BookArchive.getArchive();
    }

    @Test
    public void addBookPositiveTest() {
        List<String> author = new ArrayList<>();
        author.add("J.K. Rowling");
        Book book = new Book("Harry Potter and the chamber of secrets",
                author, 942.38, 615);
        try {
            assertTrue(dao.addBook(book));
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookDaoException.class, expectedExceptionsMessageRegExp = "book already exists")
    public void addBookNegativeTest() throws BookDaoException {
        List<String> authors = new ArrayList<>();
        authors.add("J.K. Rowling");
        Book book = new Book(2, "Harry Potter and the Philosopher’s Stone", authors, 780.8, 219);
        dao.addBook(book);
    }

    @Test(expectedExceptions = BookDaoException.class, expectedExceptionsMessageRegExp = "book doesn't exist")
    public void removeBookNegativeTest() throws BookDaoException {
        List<String> author = new ArrayList<>();
        author.add("J.K. Rowling");
        Book book = new Book("Harry Potter and the chamber of secrets",
                author, 942.38, 615);
        dao.removeBook(book);
    }

    @Test
    public void removeBookPositiveTest() {
        List<String> authors = new ArrayList<>();
        authors.add("J.K. Rowling");
        Book book = new Book(2, "Harry Potter and the Philosopher’s Stone", authors, 780.8, 219);
        try {
            assertTrue(dao.removeBook(book));
        } catch (BookDaoException e) {
            fail();
        }
    }

    @Test
    public void FindByIdPositiveTest() {
        List<Book> actual = dao.findById(5);
        List<Book> foundBooks = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        authors.add("Ralph Johnson");
        foundBooks.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
        assertEquals(foundBooks, actual);
    }

    @Test
    public void FindByTitlePositiveTest() {
        List<Book> actual = dao.findByTitle("Ralph Johnson: Complete Works");
        List<Book> foundBooks = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        authors.add("Ralph Johnson");
        foundBooks.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
        assertEquals(foundBooks, actual);
    }

    @Test
    public void FindByAuthorsPositiveTest() {
        List<Book> actual = dao.findByAuthor("Ralph Johnson");
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
    public void FindByPricePositiveTest() {
        List<Book> actual = dao.findByPrice(236.99);
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
    public void FindByPagesCommandPositiveTest() {
        List<Book> actual = dao.findByPages(448);
        List<Book> expected = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        authors.add("Ralph Johnson");
        expected.add(new Book(5, "Ralph Johnson: Complete Works", authors, 236.99, 448));
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive", dataProviderClass = StaticDataProvider.class)
    public void SortByIdPositiveTest(List<Book> expected) {
        List<Book> actual = dao.sortBooksById();
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive", dataProviderClass = StaticDataProvider.class)
    public void SortByPagesPositiveTest(List<Book> expected) {
        List<Book> actual = dao.sortBooksByPages();
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive-2", dataProviderClass = StaticDataProvider.class)
    public void SortByTitlePositiveTest(List<Book> expected) {
        List<Book> actual = dao.sortBooksByTitle();
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive-3", dataProviderClass = StaticDataProvider.class)
    public void SortByAuthorPositiveTest(List<Book> expected) {
        List<Book> actual = dao.sortBooksByAuthors();
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test(dataProvider = "sorted archive-4", dataProviderClass = StaticDataProvider.class)
    public void SortByPricePositiveTest(List<Book> expected) {
        List<Book> actual = dao.sortBooksByPrice();
        AssertJUnit.assertEquals(expected, actual);
    }
}
