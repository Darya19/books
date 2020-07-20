package com.epam.day6.model.service;

import com.epam.day6.builder.BookBuilder;
import com.epam.day6.exception.BookDaoException;
import com.epam.day6.exception.BookServiceException;
import com.epam.day6.model.dao.impl.BookListDaoImpl;
import com.epam.day6.model.entity.Book;
import com.epam.day6.parser.NumberParser;
import com.epam.day6.validator.BookValidator;

import java.util.List;

public class BookService {

    BookListDaoImpl dao = new BookListDaoImpl();

    public List<Book> addBook(String title, List<String> authors, String price, String pages) throws BookServiceException {
        NumberParser parser = new NumberParser();
        BookValidator validator = new BookValidator();
        BookBuilder builder = new BookBuilder();
        int intPages;
        double doublePrice;
        intPages = parser.parseToInt(pages);
        doublePrice = parser.parseToDouble(price);
        Book book = builder.buildBall(title, authors, doublePrice, intPages);
        if (validator.isPageQuantityValid(book.getPages()) && validator.isPriceValid(book.getPrice())
                && validator.isAuthorsListValid(book.getAuthors()) && validator.isTitleValid(book.getTitle())) {
            try {
                dao.addBook(book);
                return dao.getAllBooks();
            } catch (BookDaoException e) {
                throw new BookServiceException("book already exist", e);
            }
        } else {
            throw new BookServiceException("invalid input data");
        }
    }

    public List<Book> removeBook(String title, List<String> authors, String price, String pages) throws BookServiceException {
        NumberParser parser = new NumberParser();
        BookValidator validator = new BookValidator();
        BookBuilder builder = new BookBuilder();
        int intPages;
        double doublePrice;
        intPages = parser.parseToInt(pages);
        doublePrice = parser.parseToDouble(price);
        Book book = builder.buildBall(title, authors, doublePrice, intPages);
        if (validator.isPageQuantityValid(book.getPages()) && validator.isPriceValid(book.getPrice())
                && validator.isAuthorsListValid(book.getAuthors()) && validator.isTitleValid(book.getTitle())) {
            try {
                dao.removeBook(book);
                return dao.getAllBooks();
            } catch (BookDaoException e) {
                throw new BookServiceException("book doesn't exist", e);
            }
        } else {
            throw new BookServiceException("invalid input data");
        }
    }

    public List<Book> findById(String id) throws BookServiceException {
        NumberParser parser = new NumberParser();
        int intId = parser.parseToInt(id);
        List<Book> foundBooks = dao.findById(intId);
        return foundBooks;
    }

    public List<Book> findByTitle(String title) {
        return dao.findByTitle(title);
    }

    public List<Book> findByAuthor(String author) {
        return dao.findByAuthor(author);
    }

    public List<Book> findByPrice(String price) throws BookServiceException {
        NumberParser parser = new NumberParser();
        double doublePrice = parser.parseToDouble(price);
        return dao.findByPrice(doublePrice);
    }

    public List<Book> findByPages(String pages) throws BookServiceException {
        NumberParser parser = new NumberParser();
        int intPages = parser.parseToInt(pages);
        return dao.findByPages(intPages);
    }

    public List<Book> sortById() {
        return dao.sortBooksById();
    }

    public List<Book> sortByTitle() {
        return dao.sortBooksByTitle();
    }

    public List<Book> sortByAuthor() {
        return dao.sortBooksByAuthors();
    }

    public List<Book> sortByPrice() {
        return dao.sortBooksByPrice();
    }

    public List<Book> sortByPages() {
        return dao.sortBooksByPages();
    }
}


