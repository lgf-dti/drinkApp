package com.example.drinkapp;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private int idOrder;
    private String tableNumber;
    private Date dateOfOrder;
    private ArrayList<Drink> drinks;

    public Order(int idOrder, String tableNumber) {
        this.idOrder = idOrder;
        this.tableNumber = tableNumber;
        this.dateOfOrder = null;
        drinks = new ArrayList<Drink>();
    }

    public void addDrink(Drink aDrink){
        drinks.add(aDrink);
    }

    public void removeDrink(Drink aDrink){
        //TODO supprimer une boisson
    }

    public int getSizeListOfDrinks(){
        return drinks.size();
    }

    public double calculateOrderPrice(){
        double result = 0;
        for(Drink aDrink : drinks){
            result += aDrink.getPrice();
        }
        return result;
    }






}
