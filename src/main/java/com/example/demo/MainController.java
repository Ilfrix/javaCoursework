package com.example.demo;

import com.example.demo.entities.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.example.demo.entities.CustomUser;
//import com.example.demo.repositories.OrderRepository;
//import com.example.demo.model.Order;
import com.example.demo.services.PizzaService;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/")
    public String home() {
        return "redirect:/menu";
    }

    @GetMapping("/menu")
    public String homePage(Model model, Principal principal) {
//        if (principal != null) {
            String userName = principal.getName();
            // Получаем объект пользователя из базы данных по его имени
            Optional<CustomUser> user = userService.findByUserName(userName);

            model.addAttribute("user", user);
            model.addAttribute("pizzas", pizzaService.findAll());
            return "menu";
//        }
//        else {
//            return "cabinet";
//        }
    }

    @GetMapping("/cabinet")
    public String AccountPage(Model model, Principal principal) {
        // Получаем имя текущего пользователя из объекта Principal
        String userName = principal.getName();

        // Получаем объект пользователя из базы данных по его имени
        Optional<CustomUser> user = userService.findByUserName(userName);
        CustomUser result = user.get();

        // Добавить список заказов в модель
//        model.addAttribute("orders", orders);

        // Добавляем объект пользователя в модель для отображения на странице
        model.addAttribute("user", result);

        return "cabinet";
    }

    @GetMapping("/admin/create_pizza")
    public String CreatePizzasPage(Model model, Principal principal) {
        return "create_pizza";
    }

    @PostMapping("/admin/create_pizza")
    public String CreateNewPizza(@RequestParam String name,
                                 @RequestParam int diameter) {
        // Получаем объект пользователя из базы данных по его имени
        Pizza pizza = new Pizza();
        pizza.setName(name);
        pizza.setDiameter(diameter);
        pizzaService.savePizza(pizza);
        return "redirect:/menu";
    }

}

