package org.jfr0st.dao;

import org.jfr0st.model.Book;
import org.jfr0st.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class BookDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAll() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void create(Book book){
        jdbcTemplate.update("INSERT INTO book(title, author, w_year) VALUES (?,?,?)",
                book.getTitle(), book.getAuthor(), book.getW_year());
    }

    public List<Person> getAllPerson() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }
}
