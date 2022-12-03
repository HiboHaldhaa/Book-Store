package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcBookDao implements BookDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addBook(Book book) {

//        String sql = "INSERT INTO book (isbn13, title, overview, CoverLink, pub_date, author_id, tag_id, language_id, " +
//                "num_pages, publisher_id) " +
//                "VALUES(?,?,?,?,?,?,?,?,?,?)";
//
//        jdbcTemplate.update(sql, book.getIsbn(), book.getTitle(), book.getOverview(), book.getCoverLink(),
//                book.getPublicationDate(),  );

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

    public int addAuthor(String author) {

        String sql = "INSERT INTO author(author_name) VALUES (?) RETURNING author_id";
        int authorId = jdbcTemplate.queryForObject(sql, Integer.class, author);
        return authorId;

    }
}
