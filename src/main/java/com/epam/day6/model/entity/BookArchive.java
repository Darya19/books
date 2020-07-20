package com.epam.day6.model.entity;

import com.epam.day6.factory.BookFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookArchive {

    private List<Book> books;
    private static BookArchive archive;

    private BookArchive() {
        this.books = new ArrayList<>();
        BookFactory.createListOfBooks(books);
    }

    public static BookArchive getArchive() {
        if (archive == null) {
            archive = new BookArchive();
        }
        return archive;
    }

    public boolean addBook(Book book) {
        for (Book book1 : books) {
            if (book1.getTitle().equals(book.getTitle()) && book1.getAuthors().equals(book.getAuthors())
                    && book1.getPrice() == book.getPrice() && book1.getPages() == book.getPages())
                return false;
        }
        if (book == null) {
            return false;
        }
        books.add(book);
        return true;
    }

    public boolean removeBook(Book book) {
        for (Book book1 : books) {
            if ((book1.getTitle().equals(book.getTitle()) && book1.getAuthors().equals(book.getAuthors())
                    && book1.getPrice() == book.getPrice() && book1.getPages() == book.getPages())) {
                books.remove(book1);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return books.size();
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(this.books);
    }
}
