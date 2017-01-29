package com.temperatureconverter.kaushiknandhan.temperatureconverter;

/**
 * Created by kaushik nandhan on 1/29/2017.
 * This class is used to convert the temperature from celcius to fahrenheit or vice versa
 * Uses static methods to call methods directly with class name with instantiating
 */

public class ConverterUtil {
    /**
     *
     * @param fahrenheit
     * @return
     */
    // converts to celsius
    public static double convertFahrenheitToCelsius(float fahrenheit){
        return ((fahrenheit - 32) * 5.0 / 9.0);
    }

    /**
     *
     * @param celsius
     * @return
     */
    // converts to fahrenheit
    public static double convertCelsiusToFahrenheit(float celsius){
        return  (celsius * (9 / 5.0)) + 32;
    }
}
