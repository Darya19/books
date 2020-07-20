package com.epam.day6.builder;

import com.epam.day6.model.entity.Book;

import java.util.List;

public class BookBuilder {

    public Book buildBall(String title, List<String> authors, double price, int pages) {
        return new Book(title, authors, price, pages);
    }
}
