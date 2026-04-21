package com.spring.pizzeria.spring_la_mia_pizzeria_crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.pizzeria.spring_la_mia_pizzeria_crud.models.Pizza;
import com.spring.pizzeria.spring_la_mia_pizzeria_crud.repositories.PizzaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository repo;

    @GetMapping("/")
    public String index(Model model) {
        List<Pizza> result = repo.findAll();

        model.addAttribute("pizzas", result);
        
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        Pizza pizza = repo.findById(id).get();

        model.addAttribute(pizza);

        return "pizzas/show";
    }
    
    
}
