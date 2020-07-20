package com.epam.day6.validatortest;

import com.epam.day6.validator.BookValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class BookValidatorTest {

    BookValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new BookValidator();
    }

    @Test
    public void isTitleValidTrueTest() {
        assertTrue(validator.isTitleValid("Harry Potter"));
    }

    @Test
    public void isTitleValidFalseTest() {
        assertFalse(validator.isTitleValid("jk"));
    }

    @Test
    public void isAuthorsListValidTrueTest() {
        List<String> authors = new ArrayList<>();
        authors.add("N. Nosov");
        assertTrue(validator.isAuthorsListValid(authors));
    }

    @Test
    public void validateNumberFalseTest() {
        assertFalse(validator.isAuthorsListValid(new ArrayList<>()));
    }

    @Test
    public void isPriceValidTrueTest() {
        assertTrue(validator.isPriceValid(192));
    }

    @Test
    public void isPriceValidFalseTest() {
        assertFalse(validator.isPriceValid(-14));
    }

    @Test
    public void isPageQuantityValidTrueTest() {
        assertTrue(validator.isPageQuantityValid(269));
    }

    @Test
    public void isPageQuantityvalidFalseTest() {
        assertFalse(validator.isPageQuantityValid(-85));
    }
}
