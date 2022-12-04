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
        int secondId = sut.findIdByName("author_id", "author", "author_name", "Marquez");
        Assert.assertEquals(1, id);
        Assert.assertEquals(2, secondId);
    }

    @Test
    public void returns_correct_author_id_after_adding_new_author() {

        int id = sut.addName("author", "author_name", "Maria Duenas", "author_id");
        Assert.assertEquals(3, id);

        int secondId = sut.findIdByName("author_id", "author", "author_name", "Maria Duenas");
        Assert.assertEquals(3, secondId);

    }



}
