package com.temperatureconverter.kaushiknandhan.temperatureconverter;
/**
 * Temperature conversion app!
 * This application converts and displays the temparature in celcius or fahrenheit depending on the input given.
 * Depending on thetemparture, the background color of the layout and the image is displayed.
 * Controls for this app include edittext, button, radiogroup, radio buttons and an imageview.
 */
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText text;// Create text object to get the input value
    View view; //create object to manipulate background color
    ImageView iv; //create iv object to manipulate image view
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
                //grab CURRENT result value now in Text Field
                inputValue = Float.parseFloat(text.getText().toString());
                view = findViewById(R.id.activity_main);
                iv=(ImageView) findViewById(R.id.imageView);
                if (inputValue>90){
                    //set hex color to skyblue
                    view.setBackgroundColor(Color.parseColor("#87ceff"));
                    iv.setVisibility(View.VISIBLE);
                    //clear any prior image
                    ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                    iv.setImageResource(R.drawable.sun);  //show sun on image

                }
                else if(inputValue<0){
                    //set hex color to Red
                    view.setBackgroundColor(Color.parseColor("#DC143C"));
                    iv.setVisibility(View.VISIBLE);
                    //clear any prior image
                    ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                    iv.setImageResource(R.drawable.snowfall);  //show snowfall on image

                }
                else {
                    // set color to yellow
                    view.setBackgroundColor(Color.YELLOW);
                    // set imageview to invisible if the input is between 0 and 90
                    iv.setVisibility(View.INVISIBLE);
                    //clear any prior image
                    ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                }
                break;
        }
    }

}
