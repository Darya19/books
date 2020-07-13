package com.epam.day6.model.comparator;

import com.epam.day6.model.entity.Book;

import java.util.Comparator;

public class BookPageComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        return book1.getPages() - book2.getPages();
    }
}
