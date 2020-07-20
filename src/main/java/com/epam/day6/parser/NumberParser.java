package com.epam.day6.parser;

import com.epam.day6.exception.BookServiceException;

public class NumberParser {

    public int parseToInt(String value) throws BookServiceException {
        try {
        return Integer.parseInt(value);
        }
        catch (NumberFormatException e) {
            throw new BookServiceException("parsing issues", e);
        }
    }

    public double parseToDouble(String value) throws BookServiceException{
        try {
            return Double.parseDouble(value);
        }
        catch (NumberFormatException e) {
            throw new BookServiceException("parsing issues",e);
        }
    }
}
