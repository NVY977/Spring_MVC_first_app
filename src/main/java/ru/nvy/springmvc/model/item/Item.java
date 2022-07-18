package ru.nvy.springmvc.model.item;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Item {
    private int id;
    @Min(value =5 , message = "Cost should be greater than 5")
    private int cost;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should not be between 2 and 30 characters ")
    private String name;

    public Item() {
    }

    public Item(int id, int cost, String name) {
        this.id = id;
        this.cost = cost;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
