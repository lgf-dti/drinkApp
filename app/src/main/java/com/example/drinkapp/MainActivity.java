package com.example.drinkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonTotal;
    private TextView textViewQuantity;
    private TextView textViewTotal;
    private Spinner spinnerDrinks;
    private Order myOrder;
    private ArrayList<Drink> catalogOfDrinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
        loadCatalog();

        myOrder = new Order(1, "T01");



        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retirer un café dans l'objet Commande
                textViewQuantity.setText("");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drink selectedDrink = (Drink)spinnerDrinks.getSelectedItem();
                myOrder.addDrink(selectedDrink);
                textViewQuantity.setText("" + myOrder.getSizeListOfDrinks());
            }
        });

        buttonTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO calculer le montant de la Commande et l'afficher
                double totalOrder = myOrder.calculateOrderPrice();
                Locale locale = new Locale("fr", "FR");
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                textViewTotal.setText(currencyFormatter.format(totalOrder));
            }
        });
    }

    public void initializeUI(){
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonTotal = findViewById(R.id.buttonTotal);
        textViewQuantity = findViewById(R.id.textViewQuantity);
        textViewTotal = findViewById(R.id.textViewTotal);
        spinnerDrinks = findViewById(R.id.spinnerDrinks);
    }

    public void loadCatalog(){
        catalogOfDrinks = new ArrayList<Drink>();
        catalogOfDrinks.add(new Drink(1,"Expresso", "Coffee", 1.5f));
        catalogOfDrinks.add(new Drink(2,"Americano", "Coffee", 2.0f));
        catalogOfDrinks.add(new Drink(3,"Green Tea", "Tea", 2.6f));
        catalogOfDrinks.add(new Drink(4,"Mint Tea", "Tea", 2.6f));

        ArrayAdapter<Drink> adapter =
                new ArrayAdapter<Drink>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, catalogOfDrinks);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spinnerDrinks.setAdapter(adapter);
    }

}