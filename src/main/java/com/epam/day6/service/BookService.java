package com.epam.day6.service;

import com.epam.day6.controller.command.CommandType;
import com.epam.day6.exception.BookDAOException;
import com.epam.day6.exception.BookServiceException;
import com.epam.day6.model.dao.impl.BookListDAOImpl;
import com.epam.day6.model.entity.Book;
import com.epam.day6.response.Response;
import com.epam.day6.util.ResponseHelper;
import com.epam.day6.validator.BookValidator;

import java.util.ArrayList;
import java.util.List;

public class BookService<T> {

    BookListDAOImpl dao = new BookListDAOImpl();

    public List<Book> addBook(Book book) throws BookServiceException {
        BookValidator validator = new BookValidator();
        if (validator.isPageQuantityValid(book.getPages()) && validator.isPriceValid(book.getPrice())
                && validator.isAuthorsListValid(book.getAuthors()) && validator.isTitleValid(book.getTitle())) {
            try {
                dao.addBook(book);
                return dao.getAllBooks();
            } catch (BookDAOException e) {
                throw new BookServiceException("book already presents", e);
            }
        } else {
            throw new BookServiceException("invalid data");
        }
    }

    public List<Book> removeBook(Book book) throws BookServiceException {
        BookValidator validator = new BookValidator();
        if (validator.isPageQuantityValid(book.getPages()) && validator.isPriceValid(book.getPrice())
                && validator.isAuthorsListValid(book.getAuthors()) && validator.isTitleValid(book.getTitle())) {
            try {
                dao.removeBook(book);
                return dao.getAllBooks();
            } catch (BookDAOException e) {
                throw new BookServiceException("book doesn't exist");
            }
        } else {
            throw new BookServiceException("invalid data");
        }
    }

    public List<Book> findById(int id) {
        List<Book> foundBooks = dao.findById(id);
        return foundBooks;
    }

    public List<Book> findByTitle(String title) {
        BookValidator validator = new BookValidator();
        if (validator.isTitleValid(title)) {
            return dao.findByTitle(title);
        } else {
          return new ArrayList<>();
        }
    }

    public List<Book> findByAuthor(String author) {
            return dao.findByAuthor(author);
    }

    public List<Book> findByPrice(double price) {
        BookValidator validator = new BookValidator();
        if (validator.isPriceValid(price)) {
            return dao.findByPrice(price);
        } else {
            return new ArrayList<>();
        }
    }

    public List<Book> findByPages(int pages) {
        BookValidator validator = new BookValidator();
        if (validator.isPageQuantityValid(pages)) {
            return dao.findByPages(pages);
        } else {
            return new ArrayList<>();
        }
    }

    public List<Book> sortById() {
       return dao.sortBooksById();
    }

    public List<Book> sortByTitle() {
        return dao.sortBooksByTitle();
    }
public List<Book> sortByAuthors() {
        return dao.sortBooksByAuthors();
    }

    public List<Book> sortByPrice() {
        return dao.sortBooksByPrice();
    }

    public List<Book> sortByPages() {
        return dao.sortBooksByPages();
    }

    public List<Book> findByWordInTitle(String wordInTitle) {
        List<Book> foundBooks = new ArrayList<>();
        List<Book> books = dao.getAllBooks();
        for (Book book : books) {
            if (book.getTitle().contains(wordInTitle)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> removeByWordInTitle(String wordInTitle) throws BookServiceException {
        try {
            for (Book book : dao.getAllBooks()) {
                if (book.getTitle().contains(wordInTitle)) {
                    dao.removeBook(book);
                }
            }
        } catch (BookDAOException e) {
            throw new BookServiceException("impossible remove book");
        }
        return dao.getAllBooks();
    }
}


