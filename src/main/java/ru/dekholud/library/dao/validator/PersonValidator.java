package ru.dekholud.library.dao.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.dekholud.library.dao.model.Person;
import ru.dekholud.library.dao.repository.PersonRepository;

import java.time.Year;

@Component
public class PersonValidator implements Validator {

    private final PersonRepository personRepository;

    @Autowired
    public PersonValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Person findingPerson = personRepository.findByFio(person.getFio());

        int currentYear = Year.now().getValue();

        if (person.getYear_of_birth() > currentYear) {
            errors.rejectValue("year_of_birth", "-1", "Год рождения должен быть меньше либо равен текущему году");
        }

        if (findingPerson!=null && person.getId() != findingPerson.getId()) {
            errors.rejectValue("name", "-2", "Этот пользователь уже существует");
        }
    }

}
