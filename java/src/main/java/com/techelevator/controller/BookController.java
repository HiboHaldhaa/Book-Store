package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.model.Book;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@PreAuthorize("isAuthenticated")
//@CrossOrigin("http://localhost:8081/")
@RestController
public class BookController {

    private BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @CrossOrigin
    @RequestMapping(path = "/books", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {

        bookDao.addBook(book);

    }

    //Getiing all books

    @CrossOrigin
    @RequestMapping(path = "/getAllBooks", method = RequestMethod.GET)
    public List<Book> bookList() {
        return bookDao.getAllBooks();
    }

    //Getiing added books

    @CrossOrigin
    @RequestMapping(path = "/getAddedBooks", method = RequestMethod.GET)
    public List<Book> addedBookList() {
        return bookDao.getAddedBooks();
    }

    @RequestMapping(path = "/books/{isbn}", method = RequestMethod.GET)
    public Book getBookByIsbn(@PathVariable String isbn) {
        long longIsbn = Long.parseLong(isbn);

        return bookDao.getBookByIsbn(longIsbn);

    }

    @CrossOrigin
    @GetMapping(path = "/search")
    public Set<Book> searchBooks(@RequestParam(defaultValue = "") String title,
                                  @RequestParam(defaultValue = "") String author,
                                  @RequestParam(defaultValue = "") List<String> genre,
                                  @RequestParam(defaultValue = "") List<String> keyword,
                                  @RequestParam(defaultValue = "") String isbn) {

        Set<Book> results = new HashSet<>();

        if (!isbn.equals("")) {
            Book isbnBook = bookDao.getBookByIsbn(Long.parseLong(isbn));
            if (isbnBook != null ) {
                results.add(isbnBook);
            }
        }
        if (!title.equals("")) {
            results.addAll(bookDao.getBooksByTitle(title));
        }
        if (!author.equals("")) {
            results.addAll(bookDao.getBooksByAuthor(author));
        }

        if (!genre.isEmpty()) {
            for (String elem : genre) {
                results.addAll(bookDao.getBooksByGenre(elem));
            }
        }

        if (!keyword.isEmpty()) {
            for (String elem : keyword) {
                results.addAll(bookDao.getBooksByKeyword(elem));
            }
        }

        return results;

    }
}
