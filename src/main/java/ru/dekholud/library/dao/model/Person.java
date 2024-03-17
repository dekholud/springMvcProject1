package ru.dekholud.library.dao.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {

    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, message = "Имя должно содержать не менее 2х символов")
    private String fio;

    @NotNull
    @Min(value = 1900, message = "Год рождения должен быть выше чем 1900")
    private int year_of_birth;
}
