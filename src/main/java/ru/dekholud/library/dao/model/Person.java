package ru.dekholud.library.dao.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {

    private int id;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, message = "FIO should be bigger then 2 symbols!")
    @UniqueElements(message = "Name should be unique")
    @Pattern(regexp = "^[А-ЩЄЮІЇЯ][а-щьєюіїя']{1,}(-[А-ЩЄЮІЇЯ][а-щьєюіїя']{1,})? [А-ЩЄЮІЇЯ][а-щьєюіїя']{1,}(-[А-ЩЄЮІЇЯ][а-щьєюіїя']{1,})? [А-ЩЄЮІЇЯ][а-щьєюіїя']{1,}$", message = "Wrong fio format")
    private String fio;

    @NotNull
    @Min(value = 1900, message = "Value should be bigger then 1900")
    //@Max(value = Year.now().getValue(), message = "Value should be less then ")
    private int year_of_birth;
}
