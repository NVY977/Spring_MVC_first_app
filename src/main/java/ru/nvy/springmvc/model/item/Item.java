package ru.nvy.springmvc.model.item;

public class Item {
    private int id;
    private int cost;
    private String name;

    public Item(){

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
