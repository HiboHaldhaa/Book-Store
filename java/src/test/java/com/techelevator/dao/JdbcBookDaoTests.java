package com.techelevator.dao;

import com.techelevator.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class JdbcBookDaoTests extends BaseDaoTests{

    private static final Book BOOK_1 = new Book(9780345339713L, "The Two Towers", "J.R.R. Tolkien", LocalDate.now(),
    "English", List.of("Fantasy"), List.of("Epic"), 432, "Harper Collins", "The one ring", "coverlink.jpeg", 1  );
    private static final Book BOOK_2 = new Book(9780345339616L, "The Return of the King", "J.R.R. Tolkien", LocalDate.now(), "English",
            List.of("Fantasy"), List.of("Epic"), 500, "Harper Collins", "The End", "coverlink.png", 2);
    private static final Book BOOK_3 = new Book(9780345339333L, "The Expanse", "James S.A. Corey", LocalDate.now(),
            "Spanish", List.of("Science Fiction"), List.of("Space Opera"), 356, "Penguin", "Virus things", "spaceship.jpeg", 3);

    private JdbcBookDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBookDao(jdbcTemplate);
    }

    @Test
    public void gets_book_by_library_id() {

        sut.addBook(BOOK_1);
        Assert.assertEquals(sut.getBookByLibraryId(1), BOOK_1);
    }

    @Test
    public void adds_book_correctly() {

        sut.addBook(BOOK_1);
        Assert.assertTrue(sut.findBookByIsbn(9780345339713L));
        Book book = sut.getBookByIsbn(9780345339713L);
        sut.addBook(BOOK_2);

    }

    @Test
    public void returns_correct_author_id() {
        sut.addBook(BOOK_1);
        sut.addBook(BOOK_2);
        sut.addBook(BOOK_3);
        int id = sut.findIdByName("author_id", "author", "author_name", BOOK_1.getAuthor());
        int secondId = sut.findIdByName("author_id", "author", "author_name", BOOK_2.getAuthor());
        int thirdId = sut.findIdByName("author_id", "author", "author_name", BOOK_3.getAuthor());

        Assert.assertEquals(1, id);
        Assert.assertEquals(1, secondId);
        Assert.assertEquals(2, thirdId);
    }

    @Test
    public void finds_book_by_isbn() {

        sut.addBook(BOOK_1);
        Assert.assertTrue(sut.findBookByIsbn(9780345339713L));
        Assert.assertFalse(sut.findBookByIsbn(4));

    }

    @Test
    public void correct_author_relation() {

        sut.addBook(BOOK_1);
        sut.addBook(BOOK_2);
        int id = sut.findIdByIsbn("author_id", "book_author", BOOK_1.getIsbn());
        int secondId = sut.findIdByIsbn("author_id", "book_author",BOOK_2.getIsbn());

        Assert.assertEquals(3, id);
        Assert.assertEquals(3, secondId);

    }

    @Test
    public void correct_genre_relation() {

        sut.addBook(BOOK_1);
        sut.addBook(BOOK_2);
        int id = sut.findIdByIsbn("genre_id", "book_genre", BOOK_1.getIsbn());
        int secondId = sut.findIdByIsbn("genre_id", "book_genre", BOOK_2.getIsbn());

        Assert.assertEquals(1, id);
        Assert.assertEquals(1, secondId);

    }

    @Test
    public void correct_tag_relation() {
        sut.addBook(BOOK_1);
        sut.addBook(BOOK_2);
        int id = sut.findIdByIsbn("tag_id", "book_tag", BOOK_1.getIsbn());
        int secondId = sut.findIdByIsbn("tag_id", "book_tag", BOOK_2.getIsbn());
        Assert.assertEquals(1, id);
        Assert.assertEquals(1, secondId);
    }

    @Test
    public void correct_publisher_relation() {

        sut.addBook(BOOK_1);
        sut.addBook(BOOK_2);
        int id = sut.findIdByIsbn("publisher_id", "book_publisher", BOOK_1.getIsbn());
        int secondId = sut.findIdByIsbn("publisher_id", "book_publisher", BOOK_2.getIsbn());

        Assert.assertEquals(1, id);
        Assert.assertEquals(1, secondId);

    }

    @Test
    public void finds_book_by_author() {
        sut.addBook(BOOK_1);
        Book book = sut.getBooksByAuthor("J.R.R. Tolkien").get(0);

        Assert.assertEquals(BOOK_1, book);

    }

    @Test public void finds_book_by_title() {
        sut.addBook(BOOK_3);
        Book book = sut.getBooksByTitle("The Expanse").get(0);

        Assert.assertEquals(book, BOOK_3);
    }

}
