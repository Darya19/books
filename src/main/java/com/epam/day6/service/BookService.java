package com.epam.day6.service;

import com.epam.day6.controller.command.CommandType;
import com.epam.day6.exception.BookDAOException;
import com.epam.day6.exception.BookServiceException;
import com.epam.day6.model.dao.impl.BookListDAOImpl;
import com.epam.day6.model.entity.Book;
import com.epam.day6.response.ErrorCode;
import com.epam.day6.response.Response;
import com.epam.day6.util.ResponseHelper;
import com.epam.day6.validator.BookValidator;

import java.util.ArrayList;
import java.util.List;

public class BookService<T> {

    BookListDAOImpl dao = new BookListDAOImpl();

    public void action(CommandType command, T data) {
        switch (command) {
            case ADD_BOOK:
                addBook((Book) data);
                break;
            case REMOVE_BOOK:
                removeBook((Book) data);
                break;
            case FIND_BY_ID:
                findById((int) data);
                break;
        }
    }

    public Response<Boolean> addBook(Book book) {
        BookValidator validator = new BookValidator();
        if (validator.validatePages(book) && validator.validatePrice(book)
                && validator.validateAuthors(book) && validator.validateTitle(book)) {
            try {
                dao.addBook(book);
                return ResponseHelper.makeOkResponse(true);
            } catch (BookDAOException e) {
                return ResponseHelper.makeErrorResponse(ErrorCode.PRESENT_ERROR);
            }
        } else {
            return ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
        }
    }

    public Response<Boolean> removeBook(Book book) {
        BookValidator validator = new BookValidator();
        if (validator.validatePages(book) && validator.validatePages(book)
                && validator.validateAuthors(book) && validator.validateTitle(book)) {
            try {
                dao.removeBook(book);
                return ResponseHelper.makeOkResponse(true);
            } catch (BookDAOException e) {
                return ResponseHelper.makeErrorResponse(ErrorCode.PRESENT_ERROR);
            }
        } else {
            return ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
        }
    }

    public Response<List<Book>> findById(int id) {
        List<Book> foundBooks = dao.findById(id);
        return ResponseHelper.makeOkResponse(foundBooks);
    }

    public List<Book> findByTitle(String title) {
        return dao.findByTitle(title);
    }

    public List<Book> findByWordInTitle(String wordInTitle) {
        List<Book> foundBooks = new ArrayList<>();
        List<Book> books = dao.getAllBooks();
        for (Book book : books) {
            if (book.getTitle().matches(wordInTitle)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void removeByWordInTitle(String wordInTitle) throws BookServiceException {
        try {
            for (Book book : dao.getAllBooks()) {
                if (book.getTitle().matches(wordInTitle)) {
                    dao.removeBook(book);
                }
            }
        } catch (BookDAOException e) {
            throw new BookServiceException("impossible remove book");
        }
    }

    public Response<List<Book>> findByAuthor(String author) {
        return ResponseHelper.makeOkResponse();}

    public Response<List<Book>> findByPrice(double price) {
        return ResponseHelper.makeOkResponse();}

    public Response<List<Book>> findByPages(int pages) {
        return ResponseHelper.makeOkResponse();}

    public Response<List<Book>> sortById() {
        return ResponseHelper.makeOkResponse();}

    public Response<List<Book>> sortByITitle() {
        return ResponseHelper.makeOkResponse();}

    public Response<List<Book>> sortByAuthors() {
        return ResponseHelper.makeOkResponse();}

    public Response<List<Book>> sortByPrice() {
        return ResponseHelper.makeOkResponse();}

    public Response<List<Book>> sortByPages() {
        return ResponseHelper.makeOkResponse();}
}


