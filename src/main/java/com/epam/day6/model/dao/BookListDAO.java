package com.epam.day6.model.dao;

import com.epam.day6.exception.BookDAOException;
import com.epam.day6.model.entity.Book;

import java.util.List;

public interface BookListDAO {

    boolean addBook(Book book) throws BookDAOException;

    boolean removeBook(Book book) throws BookDAOException;

    List<Book> findById(int id);

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByPrice(double price);

    List<Book> findByPages(int pages);

    List<Book> sortBooksById();

    List<Book> sortBooksByTitle();

    List<Book> sortBooksByPrice();

    List<Book> sortBooksByAuthors();

    List<Book> sortBooksByPages();

    List<Book> getAllBooks();
}
