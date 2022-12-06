package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.model.Book;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(path = "/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author,
                                  @RequestParam(required = false) List<String> genre,
                                  @RequestParam(required = false) List<String> keywords,
                                  @RequestParam(required = false) String isbn) {

        List<Book> results = new ArrayList<>();
        
        results.add(bookDao.getBookByIsbn(Long.parseLong(isbn)));

        return results;

    }
}
