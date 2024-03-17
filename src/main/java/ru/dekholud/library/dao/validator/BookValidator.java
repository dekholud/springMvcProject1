package ru.dekholud.library.dao.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.dekholud.library.dao.model.Book;
import ru.dekholud.library.dao.repository.BookRepository;

import java.time.Year;

@Component
public class BookValidator implements Validator {

    private final BookRepository bookRepository;

    @Autowired
    public BookValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        int currentYear = Year.now().getValue();

        if (book.getYear() > currentYear) {
            errors.rejectValue("year", "-1", "Год издания должен быть меньше либо равен текущему году");
        }
    }

}
