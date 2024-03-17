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
public class Book {
    
    private int id;

    @NotEmpty(message = "Наименование книги не должно быть пустым")
    @Size(min = 2, message = "Наименование книги должно содержать минимум 2 символа")
    private String name;
    
    @NotEmpty(message = "Имя автора не должно быть пустым")
    @Size(min = 2, message = "Имя автора должно содержать минимум 2 символа")
    private String author;

    @NotNull(message = "Год издания не может быть пустым")
    @Min(value = 0, message = "Год должен быть больше нуля")
    private int year;
    
    private int personId;

}