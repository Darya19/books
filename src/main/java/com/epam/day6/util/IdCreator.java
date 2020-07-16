package com.epam.day6.util;

public class IdCreator {

    private static int id = 0;

    public static int createId() {
        return id = +id;
    }
}
