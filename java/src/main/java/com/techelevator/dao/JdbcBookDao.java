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
           LocalDate dateAdded = LocalDate.now();
           int pages = book.getPages();
           String overview = book.getOverview();
           String coverLink = book.getCoverLink();
           int languageId = bookLanguage(book.getLanguage());
           int libraryId = book.getLibraryId();

           String sql = "INSERT INTO book (isbn13, title, date_added, num_pages, language_id, overview, CoverLink, library_id) " +
                   "VALUES(?,?,?,?,?,?,?,?);";
           jdbcTemplate.update(sql, isbn, title, dateAdded, pages, languageId, overview, coverLink, libraryId);

           authorRelation(book.getAuthor(), isbn);
           if (book.getGenres() != null) {
               genresRelation(book.getGenres(), isbn);

           }
           if (book.getTags() != null) {
               tagRelation(book.getTags(), isbn);
           }
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

    @Override
    public List<Book> getBooksByGenre(String genre) {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT book.isbn13, genre_name FROM book " +
                "JOIN book_genre ON book_genre.isbn13 = book.isbn13 " +
                "JOIN genre ON genre.genre_id = book_genre.genre_id " +
                "WHERE genre_name ILIKE ?;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, "%"+genre+"%");

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
    public List<Book> getBooksByKeyword(String keyword) {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT book.isbn13, tag_word FROM book " +
                "JOIN book_tag ON book_tag.isbn13 = book.isbn13 " +
                "JOIN tag ON tag.tag_id = book_tag.tag_id " +
                "WHERE tag_word ILIKE ?;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, "%"+keyword+"%");

        List<Long> isbnList = new ArrayList<>();

        while(rows.next()){
            isbnList.add(rows.getLong("isbn13"));
        }

        for (Long isbn : isbnList) {
            books.add(getBookByIsbn(isbn));
        }

        return books;
    }

    public List<Book> getReadingList(int id) {
        List<Book> results = new ArrayList<>();

        String sql = "SELECT isbn13 FROM user_book WHERE user_id = ?;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);

        List<Long> longs = new ArrayList<>();

        while (rows.next()) {
            longs.add(rows.getLong("isbn13"));
        }

        for (Long lon : longs) {
            results.add(getBookByIsbn(lon));
        }

        return results;
    }

    //NEW added
    @Override
    public List<Book> getAllBooks() {
       List<Book> books = new ArrayList<>();

       String sql = "SELECT isbn13, title, date_added, num_pages, language_id, overview, coverlink FROM book;";
       SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

       while (results.next()) {
           books.add(mapRowToBook(results));
       }

       return books;
    }

    //NEW added Books
    @Override
    public List<Book> getAddedBooks() {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT isbn13, title, date_added, num_pages, language_id, overview, coverlink " +
                "FROM book " +
                "ORDER BY date_added ASC " +
                "LIMIT 4";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            books.add(mapRowToBook(results));
        }

        return books;
    }

    @Override
    public Book getBookByLibraryId(int libraryId) {
        Book book = null;
        String sql = "SELECT isbn13 FROM book WHERE library_id = ?;";

        long isbn = 0;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, libraryId);

        if (row.next()) {
            isbn = row.getLong("isbn13");
        }

        if (isbn != 0) {
            book = getBookByIsbn(isbn);
        }

    return book;
    }

    //Getting all data
    private Book mapRowToBook(SqlRowSet rowSet) {
        Book book = new Book();

        book.setIsbn(rowSet.getLong("isbn13"));
        book.setTitle(rowSet.getString("title"));
        //book.setDateAdded(rowSet.getDate("date_added"));
        book.setPages(rowSet.getInt("num_pages"));
        book.setLanguage(rowSet.getString("language_id"));
        book.setOverview(rowSet.getString("overview"));
        book.setCoverLink(rowSet.getString("coverlink"));


        return book;
    }




    private Book mapBook(long isbn) {

        Book book = new Book();
        String sql = "SELECT isbn13, title, date_added, num_pages, language_id, overview, coverlink, library_id FROM book " +
                "WHERE isbn13 = ?;";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, isbn);
        if (row.next()) {
            book.setIsbn(row.getLong("isbn13"));
            book.setTitle(row.getString("title"));
            book.setPages(row.getInt("num_pages"));
            book.setOverview(row.getString("overview"));
            book.setCoverLink(row.getString("coverlink"));
            book.setDateAdded(row.getDate("date_added").toLocalDate());
            book.setLibraryId(row.getInt("library_id"));
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
        if (language == "" || language == null) {
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
