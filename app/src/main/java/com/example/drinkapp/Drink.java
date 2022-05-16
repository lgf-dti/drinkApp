package com.example.drinkapp;

public class Drink {
    private int idDrink;
    private String name;
    private String category;
    private double price;

    public Drink(int idDrink, String name, String category, double price) {
        this.idDrink = idDrink;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return idDrink + " " + name;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

