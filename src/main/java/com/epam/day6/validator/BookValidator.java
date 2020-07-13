package com.epam.day6.validator;

import com.epam.day6.model.entity.Book;

public class BookValidator {

    private final int pagesMaxValue = 1000;
    private final int pagesMinValue = 1;
    private final double priceMinValue = 15.5;
    private final double priceMaxValue = 1450.0;
    private final int titleMaxLength = 100;
    private final int titleMinLength = 3;
    private final int authorsMinNumber = 1;
    private final int authorsMaxNumber = 10;

    public boolean validatePages(Book book) {
        return book.getPages() < pagesMaxValue && book.getPages() > pagesMinValue;
    }

    public boolean validatePrice(Book book) {
        return book.getPrice() > priceMinValue && book.getPrice() < priceMaxValue;
    }

    public boolean validateTitle(Book book) {
        return book.getTitle().length() > titleMinLength && book.getTitle().length() < titleMaxLength;
    }

    public boolean validateAuthors(Book book) {
        return book.getAuthors().size() > authorsMinNumber && book.getAuthors().size() < authorsMaxNumber;
    }
}
