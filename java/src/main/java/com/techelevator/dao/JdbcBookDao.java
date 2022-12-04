package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;

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
           int languageId = findIdByName("language_id", "book_language", "language_name",
                   book.getLanguage());
           if (languageId == 0) {
               languageId = addName("book_language", "language_name", book.getLanguage(),
                       "language_id");
           }
           String sql = "INSERT INTO book (isbn13, title, pub_date, num_pages, language_id, overview, CoverLink) " +
                   "VALUES(?,?,?,?,?,?,?);";
           jdbcTemplate.update(sql, isbn, title, publicationDate, pages, languageId, overview, coverLink);
       }
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

    public int addName(String tableName, String queryName, String name, String idName) {

        String sql = "INSERT INTO " + tableName + "(" + queryName + ") VALUES (?) RETURNING " + idName;
        int id = jdbcTemplate.queryForObject(sql, Integer.class, name);
        return id;

    }

}
