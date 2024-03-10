package ru.dekholud.library.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.dekholud.library.dao.mapper.PersonMapper;
import ru.dekholud.library.dao.model.Person;

import java.util.List;

import static ru.dekholud.library.dao.sql.Query.*;

@Component
public class PersonRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query(SELECT_ALL_PERSONS, new PersonMapper());
    }

    public Person findById(int id) {
        return jdbcTemplate.query(SELECT_PERSON_BY_ID, new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }

    public void deleteById(int id) {
        jdbcTemplate.update(DELETE_PERSON_BY_ID, id);
    }

    public void save(Person person) {
        jdbcTemplate.update(ADD_PERSON, person.getFio(), person.getYear_of_birth());
    }

    public void update(Person person) {
        jdbcTemplate.update(UPDATE_PERSON_BY_ID, person.getFio(), person.getYear_of_birth(), person.getId());
    }

    public Person add() {
        return new Person();
    }


}
