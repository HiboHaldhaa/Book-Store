package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.model.Book;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping(path = "/books", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {

        bookDao.addBook(book);

    }

    @RequestMapping(path = "/books/{isbn}", method = RequestMethod.GET)
    public Book getBookByIsbn(@PathVariable String isbn) {
        long longIsbn = Long.parseLong(isbn);

        return bookDao.getBookByIsbn(longIsbn);

    }
}
