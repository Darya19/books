package com.epam.day6.parsertest;

import com.epam.day6.exception.BookServiceException;
import com.epam.day6.parser.NumberParser;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class NumberParserTest {

    NumberParser parser = new NumberParser();

    @Test
    public void parseToIntPositiveTest() {
        String number = "125";
        try {
            int actual = parser.parseToInt(number);
            int expected = 125;
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class, expectedExceptionsMessageRegExp = "parsing issues")
    public void parseToIntNegativeTest() throws BookServiceException {
        String number = "jmh";
        parser.parseToInt(number);
    }

    @Test
    public void parseToDoublePositiveTest() {
        String number = "125.36";
        try {
            double actual = parser.parseToDouble(number);
            double expected = 125.36;
            assertEquals(actual, expected);
        } catch (BookServiceException e) {
            fail();
        }
    }

    @Test(expectedExceptions = BookServiceException.class)
    public void parseToDoubleNegativeTest() throws BookServiceException {
        String number = "12a.2m";
        parser.parseToDouble(number);
    }
}
