package ru.dekholud.library.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.dekholud.library.dao.model.Person;
import ru.dekholud.library.dao.repository.PersonRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/people")
public class PeopleController {
    private final PersonRepository personRepository;

    @GetMapping()
    public String findAllPerson(Model model) {
        model.addAttribute("people", personRepository.findAll());
        return "person/index";
    }

    @GetMapping("/{id}")
    public String findPersonById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personRepository.findById(id));
        return "person/view";
    }

    @GetMapping("/new")
    public String addPerson(Model model) {
        model.addAttribute("person", personRepository.add());
        return "person/new";
    }

    @PostMapping()
    public String savePerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "person/new";
        }
        personRepository.save(person);
        return "redirect:/people";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personRepository.findById(id));
        return "person/edit";
    }

    @PatchMapping("/modify")
    public String modifyPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "person/edit";
        }
        personRepository.update(person);
        return "redirect:/people";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personRepository.deleteById(id);
        return "redirect:/people";
    }
}
