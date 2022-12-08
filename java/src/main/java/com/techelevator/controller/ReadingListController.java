package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReadingListController {

    private UserDao userDao;
    public ReadingListController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping (path = "/reading-list/{id}")
    public ResponseEntity addBookToReadingList(@PathVariable int id, @RequestBody Book book) {
        if (!userDao.addToReadingList(id, book)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);

    }
}
