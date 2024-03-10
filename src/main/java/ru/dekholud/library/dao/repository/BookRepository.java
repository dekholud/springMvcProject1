package ru.dekholud.library.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.dekholud.library.dao.mapper.BookMapper;
import ru.dekholud.library.dao.model.Book;

import java.util.List;

import static ru.dekholud.library.dao.sql.Query.*;

@Component
public class BookRepository {
    /**
     TODO
     сделать нормальную валидацию полей
     задействовать dto
     отрефакторить dao
     решить проблему с update у book
     убрать warnings
     */

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> findAll() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS, new BookMapper());
    }

    public Book findById(int id) {
        return jdbcTemplate.query(SELECT_BOOK_BY_ID, new Object[]{id}, new BookMapper())
                .stream().findAny().orElse(null);
    }

    public void deleteById(int id) {
        jdbcTemplate.update(DELETE_BOOK_BY_ID, id);
    }

    public void save(Book book) {
        jdbcTemplate.update(ADD_BOOK, book.getName(), book.getAuthor(), book.getYear(), null);
    }

    public void update(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_BY_ID, book.getName(), book.getAuthor(), book.getYear(), book.getPersonId(), book.getId());
    }

    public Book add() {
        return new Book();
    }

}
