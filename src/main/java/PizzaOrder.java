package com.pizza.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class PizzaOrder {
    @Id
    private String id;
    private String userName;
    private String pizzaType;
    private String pizzaSize;
    private boolean extraCheese;
    private boolean extraToppings;
    private boolean takeaway;
    private int totalPrice;

    // Default Constructor
    public PizzaOrder() {}

    // Parameterized Constructor
    public PizzaOrder(String userName, String pizzaType, String pizzaSize, boolean extraCheese, boolean extraToppings, boolean takeaway, int totalPrice) {
        this.userName = userName;
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        this.extraCheese = extraCheese;
        this.extraToppings = extraToppings;
        this.takeaway = takeaway;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isExtraToppings() {
        return extraToppings;
    }

    public void setExtraToppings(boolean extraToppings) {
        this.extraToppings = extraToppings;
    }

    public boolean isTakeaway() {
        return takeaway;
    }

    public void setTakeaway(boolean takeaway) {
        this.takeaway = takeaway;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
