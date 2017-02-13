package com.anthony;

import javax.security.auth.Subject;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by eclipze on 2017/02/06.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement{
    Observable observable;
    private double temperature;
    private double humidity;
    private double pressure;
    private Subject subject;


    //Constructor: register this display as an observer during instantiation
    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {

        System.out.println("Current conditions: " + temperature +
                "F degrees and " + humidity + "% humidity");

    }
}
