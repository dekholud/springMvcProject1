package ru.dekholud.library.dao.sql;

public class Query {
    public static final String SELECT_ALL_BOOKS = "SELECT * FROM book";
    public static final String SELECT_BOOK_BY_ID = "SELECT * from book where id = ?";
    public static final String DELETE_BOOK_BY_ID = "DELETE from book where id=?";
    public static final String INSERT_BOOK = "INSERT INTO book (name, author, year, person_id) values (?,?,?,?)";
    public static final String UPDATE_BOOK_BY_ID = "UPDATE book SET name=?, author=?, year=? where id=?";
    public static final String SELECT_ALL_PERSONS = "SELECT * FROM person";
    public static final String SELECT_PERSON_BY_ID = "SELECT * from person where id = ?";
    public static final String SELECT_PERSON_BY_FIO = "SELECT * from person where fio = ?";
    public static final String DELETE_PERSON_BY_ID = "DELETE from person where id=?";
    public static final String INSERT_PERSON = "INSERT INTO person (fio, year_of_birth) values (?,?)";
    public static final String UPDATE_PERSON_BY_ID = "UPDATE person SET fio=?, year_of_birth=? where id=?";
}
