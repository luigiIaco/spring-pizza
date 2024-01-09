package com.example.hellopizza.controller;

import com.example.hellopizza.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PizzaController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping
    public String index() {

        return "list";
    }
}
