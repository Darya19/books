package com.epam.day6.factory;

import com.epam.day6.model.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookFactory {

    public void createListOfBooks(List<Book> bookList){
        IdCreator id = new IdCreator();
            bookList.add(new Book(id.createId(0), "Charlotte’s Web", new ArrayList<String>(), 156.8));
        bookList.add(new Book(id.createId(1), "Winnie-the-Pooh", new ArrayList<String>(), 156.8));

    }
}
