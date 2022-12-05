package com.techelevator.dao;

import com.techelevator.model.Book;

public interface BookDao {

    public void addBook(Book book);

    public Book getBookByIsbn(long isbn);
}
