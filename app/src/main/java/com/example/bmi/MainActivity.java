package com.example.bmi;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput;
    private EditText heightInput;
    private TextView resultOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weight_input);
        heightInput = findViewById(R.id.height_input);
        resultOutput = findViewById(R.id.result_output);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightString = weightInput.getText().toString();
        String heightString = heightInput.getText().toString();

        if (weightString.isEmpty() || heightString.isEmpty()) {
            resultOutput.setText("");
            return;
        }

        float weight = Float.parseFloat(weightString);
        float height = Float.parseFloat(heightString) / 100; // convert cm to m
        float bmi = weight / (height * height);

        String bmiString = String.format("%.1f", bmi);
        resultOutput.setText(bmiString);
    }
}
