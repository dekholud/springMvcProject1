package ru.dekholud.library.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.dekholud.library.dao.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(rs.getInt("id"),
                rs.getString("fio"),
                rs.getInt("year_of_birth"));
    }
}