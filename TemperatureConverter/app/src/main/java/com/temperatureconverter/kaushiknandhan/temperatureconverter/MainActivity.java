package com.temperatureconverter.kaushiknandhan.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText text;// Create text object to get the input value
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText)findViewById(R.id.editText);
    }
        /* this method is called when user clicks the button and is handled
    because we assigned the name to the "OnClick property" of the
    button */

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                // Declaration and initialization of radio buttons for celsius and fahrenheit
                RadioButton celsiusButton = (RadioButton)
                        findViewById(R.id.radioButton);
                RadioButton fahrenheitButton = (RadioButton)
                        findViewById(R.id.radioButton2);
                // Displays a pop up "Please enter a valid number", if the text filed is empty.
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(text.getText().toString());// Takes the value of the input given in text field.
                // Checks the celcius radio button is checked and converts the input value to fahrenheit, checks the fahrenheitButton and unchecks the celsiusButton
                if (celsiusButton.isChecked()) {
                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));// text value is displayed after conversion
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                } else {
                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));// text value is displayed after conversion
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }
                break;
        }
    }

}
