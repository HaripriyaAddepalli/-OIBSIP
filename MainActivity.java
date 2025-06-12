package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputValue;
    Spinner spinnerConversionType;
    Button convertButton;
    TextView resultText;

    String[] conversionOptions = {
        "Centimeters to Meters",
        "Meters to Centimeters",
        "Grams to Kilograms",
        "Kilograms to Grams"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        spinnerConversionType = findViewById(R.id.spinnerConversionType);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, conversionOptions);
        spinnerConversionType.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    private void convert() {
        String input = inputValue.getText().toString();

        if (input.isEmpty()) {
            resultText.setText("Please enter a value.");
            return;
        }

        double value = Double.parseDouble(input);
        String selectedOption = spinnerConversionType.getSelectedItem().toString();
        double result = 0;
        String unit = "";

        switch (selectedOption) {
            case "Centimeters to Meters":
                result = value / 100;
                unit = "meters";
                break;
            case "Meters to Centimeters":
                result = value * 100;
                unit = "centimeters";
                break;
            case "Grams to Kilograms":
                result = value / 1000;
                unit = "kilograms";
                break;
            case "Kilograms to Grams":
                result = value * 1000;
                unit = "grams";
                break;
        }

        resultText.setText("Converted Value: " + result + " " + unit);
    }
}
