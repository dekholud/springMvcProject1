package ru.dekholud.library.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.dekholud.library.dao.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("author"),
                rs.getInt("year"),
                rs.getInt("person_id"));
    }
}