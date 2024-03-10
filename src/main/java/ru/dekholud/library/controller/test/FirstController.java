package ru.dekholud.library.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class FirstController {

    @GetMapping("/hello")
    public String HelloPage(
                            Model model) {
        model.addAttribute("message", "Hello user!");
        return "test/hello";
    }

}
