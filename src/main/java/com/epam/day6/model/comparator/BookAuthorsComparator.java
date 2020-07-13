package com.epam.day6.model.comparator;

import com.epam.day6.model.entity.Book;

import java.util.Comparator;

public class BookAuthorsComparator  implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
      return book1.getAuthors().get(0).compareTo((book2).getAuthors().get(0));
    }
}
