package com.example.mlower.tipcalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double mealCost;
    double tipValue;
    double tipPercent;
    String tipChoice;
    String holdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText cost = findViewById(R.id.txtMealCost);
        final Spinner group = findViewById(R.id.txtTipRate);
        Button charges = findViewById(R.id.btn_calculate);
            charges.setOnClickListener(new View.OnClickListener() {
                final TextView result = findViewById(R.id.txtResult);

                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    holdEditText = cost.getText().toString();
                    try {
                        mealCost = Double.parseDouble(holdEditText);
                    } catch (NumberFormatException d) {
                        mealCost = 0.0;
                    }

                    tipChoice = group.getSelectedItem().toString();

                    switch (tipChoice) {

                        case "5%":
                            tipPercent = .05;
                            break;

                        case "10%":
                            tipPercent = .1;
                            break;

                        case "15%":
                            tipPercent = .15;
                            break;

                        case "20%":
                            tipPercent = .2;
                            break;

                        case "25%":
                            tipPercent = .25;
                            break;
                    }

                    tipValue = mealCost * tipPercent;
                    java.text.DecimalFormat currency = new java.text.DecimalFormat("$###,###.00");
                    result.setText("Your tip total is: " + currency.format(tipValue));

                }
                 });

    }
}

