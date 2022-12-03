package com.techelevator.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcBookDaoTests extends BaseDaoTests{

    private JdbcBookDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBookDao(jdbcTemplate);
    }

    @Test
    public void returns_correct_author_id() {
        int id = sut.findIdByName("author_id", "author", "author_name", "Tolkien");

        Assert.assertEquals(1, id);
    }

    @Test
    public void returns_correct_author_id_adding_author() {

        int id = sut.addAuthor("Maria Duenas");
        Assert.assertEquals(2, id);

    }


}
