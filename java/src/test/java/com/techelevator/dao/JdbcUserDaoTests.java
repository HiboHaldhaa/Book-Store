package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.User;
import com.techelevator.model.UserNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class JdbcUserDaoTests extends BaseDaoTests {
    protected static final User USER_1 = new User(1L, "user1", "user1", "ROLE_USER");
    protected static final User USER_2 = new User(2L, "user2", "user2", "ROLE_USER");
    private static final User USER_3 = new User(3L, "user3", "user3", "ROLE_USER");

    private static final Book BOOK_1 = new Book(9780345339713L, "The Two Towers", "J.R.R. Tolkien", LocalDate.now(),
            "English", List.of("Fantasy"), List.of("Epic"), 432, "Harper Collins", "The one ring", "coverlink.jpeg", 1);
    private static final Book BOOK_2 = new Book(9780345339616L, "The Return of the King", "J.R.R. Tolkien", LocalDate.now(), "English",
            List.of("Fantasy"), List.of("Epic"), 500, "Harper Collins", "The End", "coverlink.png", 1);

    private JdbcUserDao sut;
    private JdbcBookDao bookDao;


    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
        bookDao = new JdbcBookDao(jdbcTemplate);
    }

    @Test
    public void readingListCreated(){
       bookDao.addBook(BOOK_1);
        Assert.assertTrue (sut.addToReadingList(1,BOOK_1));
        Assert.assertFalse(sut.addToReadingList(1, BOOK_1));
    }

    @Test
    public void reading_list_retrieved_successfully() {
        bookDao.addBook(BOOK_1);
        bookDao.addBook(BOOK_2);

        sut.addToReadingList(1, BOOK_1);
        sut.addToReadingList(1, BOOK_2);

        List<Book> list = bookDao.getReadingList(1);

        Assert.assertEquals(2, list.size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void findIdByUsername_given_null_throws_exception() {
        sut.findIdByUsername(null);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void findIdByUsername_given_invalid_username_throws_exception() {
        sut.findIdByUsername("invalid");
    }

    @Test
    public void findIdByUsername_given_valid_user_returns_user_id() {
        int actualUserId = sut.findIdByUsername(USER_1.getUsername());

        Assert.assertEquals(USER_1.getId().intValue(), actualUserId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByUsername_given_null_throws_exception() {
        sut.findByUsername(null);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void findByUsername_given_invalid_username_throws_exception() {
        sut.findByUsername("invalid");
    }

    @Test
    public void findByUsername_given_valid_user_returns_user() {
        User actualUser = sut.findByUsername(USER_1.getUsername());

        Assert.assertEquals(USER_1, actualUser);
    }

    @Test(expected = UserNotFoundException.class)
    public void getUserById_given_null_throws_exception() {
        sut.getUserById(null);
    }

    @Test(expected = UserNotFoundException.class)
    public void getUserById_given_invalid_user_id_throws_exception() {
        sut.getUserById(-1L);
    }

    @Test
    public void getUserById_given_valid_user_id_returns_user() {
        User actualUser = sut.getUserById(USER_1.getId());

        Assert.assertEquals(USER_1, actualUser);
    }

    @Test
    public void findAll_returns_all_users() {
        List<User> users = sut.findAll();

        Assert.assertNotNull(users);
        Assert.assertEquals(3, users.size());
        Assert.assertEquals(USER_1, users.get(0));
        Assert.assertEquals(USER_2, users.get(1));
        Assert.assertEquals(USER_3, users.get(2));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void create_user_with_null_username() {
        sut.create(null, USER_3.getPassword(), "ROLE_USER");
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void create_user_with_existing_username() {
        sut.create(USER_1.getUsername(), USER_3.getPassword(), "ROLE_USER");
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_user_with_null_password() {
        sut.create(USER_3.getUsername(), null, "ROLE_USER");
    }

    @Test
    public void create_user_creates_a_user() {
        User newUser = new User(-1L, "new", "user", "ROLE_USER");

        boolean userWasCreated = sut.create(newUser.getUsername(), newUser.getPassword(), "ROLE_USER");

        Assert.assertTrue(userWasCreated);

        User actualUser = sut.findByUsername(newUser.getUsername());
        newUser.setId(actualUser.getId());

        actualUser.setPassword(newUser.getPassword()); // reset password back to unhashed password for testing
        Assert.assertEquals(newUser, actualUser);
    }
}
