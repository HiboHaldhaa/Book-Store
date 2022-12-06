package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {

    public void addBook(Book book);

    public Book getBookByIsbn(long isbn);

    public List<Book> getBooksByTitle(String title);

    public List<Book> getBooksByAuthor(String author);
}
