package com.epam.day6.factory;

import com.epam.day6.model.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookFactory {

    public static void createListOfBooks(List<Book> bookList) {
        List<String> authors = new ArrayList<>();
        authors.add("Alan Alexander Milne");
        authors.add("P.G.Wodehouse");
        bookList.add(new Book("Winnie-the-Pooh", authors, 458.96, 194));
        authors = new ArrayList<>();
        authors.add("J.K. Rowling");
        bookList.add(new Book("Harry Potter and the Philosopher’s Stone", authors, 780.8, 219));
        authors = new ArrayList<>();
        authors.add("Arthur Hailey");
        bookList.add(new Book("Airport", authors, 746.36, 277));
        authors = new ArrayList<>();
        authors.add("Erich Gamma");
        authors.add("Richard Helm");
        authors.add("Ralph Johnson");
        authors.add("John Vlissides");
        bookList.add(new Book("Design Patterns: Elements of Reusable Object-Oriented Software",
                authors, 236.99, 312));
        authors = new ArrayList<>();
        authors.add("Ralph Johnson");
        bookList.add(new Book("Ralph Johnson: Complete Works", authors, 236.99, 448));
    }
}
