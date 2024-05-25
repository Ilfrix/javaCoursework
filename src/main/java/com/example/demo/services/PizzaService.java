package com.example.demo.services;

import com.example.demo.entities.Pizza;
import com.example.demo.repositories.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PizzaService {
    private PizzaRepository pizzaRepository;


    public void savePizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }
    public Long createPizza(Long id, String name, int diameter, float cost){
        Pizza pizza = new Pizza(id, name, diameter, cost);
        pizzaRepository.save(pizza);
        return pizza.getId();
    }
    public Pizza getPizza(Long id) {
        var pizza = pizzaRepository.findById(id);
        return pizza.get();
    }
    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }
    public void updatePizza(Long id, String name, int diameter){
        var optionalPizza = pizzaRepository.findById(id);
        var pizza = optionalPizza.get();
        pizza.name = name;
        pizza.diameter = diameter;
        pizzaRepository.save(pizza);
    }

    public Iterable<Pizza> findAll() {
        return pizzaRepository.findAll();
    }
}