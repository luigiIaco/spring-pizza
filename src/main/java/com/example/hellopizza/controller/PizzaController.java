package com.example.hellopizza.controller;

import com.example.hellopizza.model.Pizza;
import com.example.hellopizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;
    @GetMapping("/lista")
    public String index(Model model) {
        List<Pizza> pizzaList = pizzaRepository.findAll();
        model.addAttribute("pizzaList", pizzaList);

        return "list";
    }

    @GetMapping("/lista/{id}")
    public String index_due(@PathVariable Integer id,Model model) {
        Optional<Pizza> result = pizzaRepository.findById(id);
        if(result.isPresent()) {
            Pizza pizza= result.get();
            model.addAttribute("pizza",pizza);
            return "details";
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + id + " not found");
        }


    }


}
