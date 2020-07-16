package com.epam.day6.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookArchive {

    private List<Book> books;
    private static BookArchive archive;

    private BookArchive() {
        this.books = new ArrayList<>();
    }

    public static BookArchive getArchive() {
        if (archive == null) {
            archive = new BookArchive();
        }
        return archive;
    }

    public boolean addBook(Book book) {
        if (books.contains(book)) {
            return false;
        }
        if (book == null) {
            return false;
        }
        books.add(book);
        return true;
    }

    public boolean removeBook(Book book) {
        if (!books.contains(book)) {
            return false;
        }
        if (book == null) {
            return false;
        }
        books.remove(book);
        return true;
    }

    public int size() {
        return books.size();
    }

    public List<Book> getBooks() {
        List<Book> copyBooks = new ArrayList<>();
        Collections.copy(books, copyBooks);
        return copyBooks;
    }
}
