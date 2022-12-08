package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ReadingListController {

    private UserDao userDao;
    private BookDao bookDao;

    public ReadingListController(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    @PostMapping (path = "/reading-list/{id}")
    public ResponseEntity addBookToReadingList(@PathVariable int id, @RequestBody Book book) {
        if (!userDao.addToReadingList(id, book)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping (path = "/reading-list/{id}")
        public List<Book> getReadingList(@PathVariable int id) {

        List<Book> readingList = new ArrayList<>();

        readingList = bookDao.getReadingList(id);

        return readingList;
    }

    @RequestMapping (path = "/reading-list/{id}?isbn=", method = RequestMethod.DELETE)
    public void deleteFromReadingList(@PathVariable int id, long isbn) {

        userDao.deleteFromReadingList(id, isbn);

    }
}
