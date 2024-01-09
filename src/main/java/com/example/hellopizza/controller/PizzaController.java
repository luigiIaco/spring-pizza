package com.example.hellopizza.controller;

import com.example.hellopizza.model.Pizza;
import com.example.hellopizza.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class PizzaController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping
    public String index(Model model) {
        List<Pizza> pizzaList = bookRepository.findAll();
        model.addAttribute("pizzaList", pizzaList);

        return "lista";
    }
}
