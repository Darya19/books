package com.epam.day6.model.dao.impl;

import com.epam.day6.model.comparator.*;
import com.epam.day6.model.dao.BookListDAO;
import com.epam.day6.model.entity.Book;
import com.epam.day6.model.entity.BookArchive;
import com.epam.day6.exception.BookDAOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookListDAOImpl implements BookListDAO {

    @Override
    public boolean addBook(Book book) throws BookDAOException {
        if (!BookArchive.getArchive().addBook(book)) {
            throw new BookDAOException("impossible add book");
        } else {
            return true;
        }
    }

    @Override
    public boolean removeBook(Book book) throws BookDAOException {
        if (!BookArchive.getArchive().removeBook(book)) {
            throw new BookDAOException("impossible remove book");
        } else {
            return true;
        }
    }

    @Override
    public List<Book> findById(int id) {
        List<Book> foundBooks = new ArrayList<>();
        for(Book book : BookArchive.getArchive().getBooks()) {
        if(book.getId() == id) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> findByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for(Book book : BookArchive.getArchive().getBooks()) {
            if(book.getTitle() == title) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for(Book book : BookArchive.getArchive().getBooks()) {
            if(book.getAuthors().contains(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> findByPrice(double price) {
        List<Book> foundBooks = new ArrayList<>();
        for(Book book : BookArchive.getArchive().getBooks()) {
            if(book.getPrice() == price) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> findByPages(int pages) {
        List<Book> foundBooks = new ArrayList<>();
        for(Book book : BookArchive.getArchive().getBooks()) {
            if(book.getPages() == pages) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> sortBooksById() {
        List<Book> sortedArchive = new ArrayList<>();
        for(Book book : BookArchive.getArchive().getBooks()) {
            sortedArchive.add(book);
        }
        Collections.sort(sortedArchive, new BookIdComparator());
        return sortedArchive;
    }

    @Override
    public List<Book> sortBooksByTitle() {
        List<Book> sortedArchive = new ArrayList<>();
        for(Book book : BookArchive.getArchive().getBooks()) {
            sortedArchive.add(book);
        }
        Collections.sort(sortedArchive, new BookTitleComparator());
        return sortedArchive;
    }

    @Override
    public List<Book> sortBooksByPrice() {
        List<Book> sortedArchive = new ArrayList<>();
        for(Book book : BookArchive.getArchive().getBooks()) {
            sortedArchive.add(book);
        }
        Collections.sort(sortedArchive, new BookPriceComparator());
        return sortedArchive;
    }

    @Override
    public List<Book> sortBooksByAuthors() {
        List<Book> sortedArchive = new ArrayList<>();
        for(Book book : BookArchive.getArchive().getBooks()) {
            sortedArchive.add(book);
        }
        Collections.sort(sortedArchive, new BookAuthorsComparator());
        return null;
    }

    @Override
    public List<Book> sortBooksByPages() {
        List<Book> sortedArchive = new ArrayList<>();
        for(Book book : BookArchive.getArchive().getBooks()) {
            sortedArchive.add(book);
        }
        Collections.sort(sortedArchive, new BookPageComparator());
        return sortedArchive;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        Collections.copy(BookArchive.getArchive().getBooks(), books);
        return books;
    }


}
