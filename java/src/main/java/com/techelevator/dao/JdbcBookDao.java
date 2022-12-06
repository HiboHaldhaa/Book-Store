package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookDao implements BookDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addBook(Book book) {

       boolean isBookInDatabase = findBookByIsbn(book.getIsbn());

       if (!isBookInDatabase) {

           long isbn = book.getIsbn();
           String title = book.getTitle();
           LocalDate publicationDate = book.getPublicationDate();
           int pages = book.getPages();
           String overview = book.getOverview();
           String coverLink = book.getCoverLink();
           int languageId = bookLanguage(book.getLanguage());

           String sql = "INSERT INTO book (isbn13, title, pub_date, num_pages, language_id, overview, CoverLink) " +
                   "VALUES(?,?,?,?,?,?,?);";
           jdbcTemplate.update(sql, isbn, title, publicationDate, pages, languageId, overview, coverLink);

           authorRelation(book.getAuthor(), isbn);
           genresRelation(book.getGenres(), isbn);
           tagRelation(book.getTags(), isbn);
           publisherRelation(book.getPublisher(), isbn);
       }

    }

    @Override
    public Book getBookByIsbn(long isbn) {

        Book book = null;

        if (!findBookByIsbn(isbn)) {
            return book;
        }

        book = mapBook(isbn);
        return book;
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT isbn13, title FROM book WHERE title ILIKE ?;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, "%"+title+"%");

        List<Long> isbnList = new ArrayList<>();

        while(rows.next()){
            isbnList.add(rows.getLong("isbn13"));
        }

        for (Long isbn : isbnList) {
            books.add(getBookByIsbn(isbn));
        }

        return books;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT book.isbn13 FROM author " +
                "JOIN book_author ON book_author.author_id = author.author_id " +
                "JOIN book ON book.isbn13 = book_author.isbn13 " +
                "WHERE author_name ILIKE ?;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, "%"+author+"%");

        List<Long> isbnList = new ArrayList<>();

        while(rows.next()){
            isbnList.add(rows.getLong("isbn13"));
        }

        for (Long isbn : isbnList) {
            books.add(getBookByIsbn(isbn));
        }

        return books;
    }


    private Book mapBook(long isbn) {

        Book book = new Book();
        String sql = "SELECT isbn13, title, pub_date, num_pages, language_id, overview, coverlink FROM book " +
                "WHERE isbn13 = ?;";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, isbn);
        if (row.next()) {
            book.setIsbn(row.getLong("isbn13"));
            book.setTitle(row.getString("title"));
            book.setPages(row.getInt("num_pages"));
            book.setOverview(row.getString("overview"));
            book.setCoverLink(row.getString("coverlink"));
            if (row.getDate("pub_date") == null) {
                book.setPublicationDate(LocalDate.MIN);
            } else {
                book.setPublicationDate(row.getDate("pub_date").toLocalDate());
            }
            int languageId = row.getInt("language_id");
            if (languageId == 0) {
                book.setLanguage("Not Available");
            } else {
                sql = "SELECT language_id, language_name FROM book_language WHERE language_id = ?;";
                row = jdbcTemplate.queryForRowSet(sql, languageId);
                if (row.next()) {
                    book.setLanguage(row.getString("language_name"));
                }
            }
            sql = "SELECT isbn13, author_name FROM book_author " +
                    "JOIN author ON author.author_id = book_author.author_id " +
                    "WHERE isbn13 = ?;";
            row = jdbcTemplate.queryForRowSet(sql, isbn);
            if (row.next()) {
                book.setAuthor(row.getString("author_name"));
            }
            book.setGenres(mapGenres(isbn));
            book.setTags(mapTags(isbn));
        }
        return book;
    }

    private List<String> mapTags(long isbn) {
        List<String> tags = new ArrayList<>();

        String sql = "SELECT isbn13, tag_word FROM book_tag " +
                "JOIN tag ON tag.tag_id = book_tag.tag_id " +
                "WHERE isbn13 = ?;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, isbn);

        while (rows.next()) {
            tags.add(rows.getString("tag_word"));
        }

        return tags;
    }

    private List<String> mapGenres(long isbn) {
        List<String> genres = new ArrayList<>();

        String sql = "SELECT isbn13, genre_name FROM book_genre " +
                "JOIN genre ON genre.genre_id = book_genre.genre_id " +
                "WHERE isbn13 = ?;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, isbn);

        while (rows.next()) {
            genres.add(rows.getString("genre_name"));
        }

        return genres;

    }

    public int bookLanguage(String language) {
        if (language == "") {
            return 0;
        }

        int languageId = findIdByName("language_id", "book_language", "language_name", language);
        if (languageId == 0) {
            languageId = addName("book_language", "language_name", language,
                    "language_id");
        }

        return languageId;
    }

    public void publisherRelation(String publisher, long isbn) {

        int publisherId = findIdByName("publisher_id", "publisher", "publisher_name", publisher);

        if (publisherId == 0) {
            publisherId = addName("publisher", "publisher_name", publisher, "publisher_id");
        }

        String sql = "INSERT INTO book_publisher (isbn13, publisher_id) VALUES (?,?);";
        jdbcTemplate.update(sql, isbn, publisherId);


    }

    public void tagRelation(List<String> tags, long isbn) {

        for (String tag : tags) {
            int tag_id = findIdByName("tag_id", "tag", "tag_word", tag);
            if (tag_id == 0) {
                tag_id = addName("tag", "tag_word", tag, "tag_id");
            }
            String sql = "INSERT INTO book_tag(isbn13, tag_id) VALUES (?,?);";
            jdbcTemplate.update(sql, isbn, tag_id);
        }

    }

    public void genresRelation(List<String> genres, long isbn) {

        for (String genre : genres) {
            int genre_id = findIdByName("genre_id", "genre", "genre_name", genre);
            if (genre_id == 0) {
                genre_id = addName("genre", "genre_name", genre, "genre_id");
            }
            String sql = "INSERT INTO book_genre(isbn13, genre_id) VALUES (?,?);";
            jdbcTemplate.update(sql, isbn, genre_id);
        }

    }

    public void authorRelation(String author, long isbn) {

        int authorId = findIdByName("author_id", "author", "author_name", author);

        if (authorId == 0) {
            authorId = addName("author", "author_name", author, "author_id");
        }

        String sql = "INSERT INTO book_author (isbn13, author_id) VALUES (?,?);";
        jdbcTemplate.update(sql, isbn, authorId);

    }

    public boolean findBookByIsbn(long isbn) {

        String sql = "SELECT isbn13 FROM book WHERE isbn13 = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, isbn);

        if (row.next()) {
            return true;
        }

        return false;

    }

    public int findIdByName(String idName, String tableName, String queryName, String name) {
        String sql = "SELECT " + idName + " FROM " + tableName + " WHERE " + queryName + " = ?";
        int id = 0;
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, name);
        if (row.next()) {
            id = row.getInt(idName);
        }
        return id;
    }

    public int findIdByIsbn(String idName, String tableName, long isbn) {
        String sql = "SELECT " + idName + " FROM " + tableName + " WHERE isbn13 = ?";
        int id = 0;
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, isbn);
        if (row.next()) {
            id = row.getInt(idName);
        }
        return id;
    }

    public int addName(String tableName, String queryName, String name, String idName) {

        String sql = "INSERT INTO " + tableName + "(" + queryName + ") VALUES (?) RETURNING " + idName;
        int id = jdbcTemplate.queryForObject(sql, Integer.class, name);
        return id;

    }

}
