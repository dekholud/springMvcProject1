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
    
    @NotEmpty(message = "Book Name should not be empty!")
    @Size(min = 2, message = "Name should be bigger then 2 symbols!")
    private String name;
    
    @NotEmpty(message = "Author name should not be empty!")
    @Size(min = 2, message = "Author name should be bigger then 2 symbols!")
    private String author;

    @NotNull
    @Min(value = 0, message = "Value should be bigger then zero")
    //@Max(value = Year.now().getValue(), message = "Value should be less then ")
    private int year;
    
    private int personId;

}