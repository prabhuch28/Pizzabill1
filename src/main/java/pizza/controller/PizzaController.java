
package com.pizza.controller;

import com.pizza.model.PizzaOrder;
import com.pizza.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaController {

    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/order")
    public String placeOrder(
            @RequestParam String userName,
            @RequestParam String pizzaType,
            @RequestParam String pizzaSize,
            @RequestParam(required = false) boolean extraCheese,
            @RequestParam(required = false) boolean extraToppings,
            @RequestParam(required = false) boolean takeaway,
            Model model) {

        int basePrice = calculateBasePrice(pizzaType, pizzaSize);
        int totalPrice = basePrice;
        if (extraCheese) totalPrice += 100;
        if (extraToppings) totalPrice += 150;
        if (takeaway) totalPrice += 20;

        PizzaOrder order = new PizzaOrder();
        order.setUserName(userName);
        order.setPizzaType(pizzaType);
        order.setPizzaSize(pizzaSize);
        order.setExtraCheese(extraCheese);
        order.setExtraToppings(extraToppings);
        order.setTakeaway(takeaway);
        order.setTotalPrice(totalPrice);

        pizzaOrderRepository.save(order);

        model.addAttribute("order", order);
        return "bill";
    }

    private int calculateBasePrice(String pizzaType, String pizzaSize) {
        if (pizzaSize.equals("small")) {
            return pizzaType.equals("veg") ? 200 : 300;
        } else if (pizzaSize.equals("medium")) {
            return pizzaType.equals("veg") ? 300 : 400;
        } else if (pizzaSize.equals("large")) {
            return pizzaType.equals("veg") ? 400 : 500;
        }
        return 0;
    }
}