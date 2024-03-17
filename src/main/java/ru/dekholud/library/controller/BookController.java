package ru.dekholud.library.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.dekholud.library.dao.model.Book;
import ru.dekholud.library.dao.repository.BookRepository;
import ru.dekholud.library.dao.validator.BookValidator;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;
    private final BookValidator bookValidator;

    @GetMapping()
    public String findAllBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/index";
    }

    @GetMapping("/{id}")
    public String findBookById(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        return "book/view";
    }

    @GetMapping("/new")
    public String addBook(Model model) {
        model.addAttribute("book", bookRepository.add());
        return "book/new";
    }

    @PostMapping()
    public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            return "book/new";
        }
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        return "book/edit";
    }

    @PatchMapping("/modify")
    public String modifyBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            return "book/edit";
        }
        bookRepository.update(book);
        return "redirect:/books";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}
